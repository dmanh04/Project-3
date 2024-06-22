package com.javaweb.service.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<TransactionEntity> findByCodeAndCustomerId(String code, Long id) {
        return transactionRepository.findByCodeAndCustomer_Id(code, id);
    }

    @Override
    public void addTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = new TransactionEntity();
        if(transactionDTO.getId() != null){
            TransactionEntity transactionExits = transactionRepository.findById(transactionDTO.getId()).get();
            transactionEntity.setCustomer(transactionExits.getCustomer());
            transactionEntity.setId(transactionExits.getId());
            transactionEntity.setCreatedDate(transactionExits.getCreatedDate());
            transactionEntity.setCreatedBy(transactionExits.getCreatedBy());
            transactionEntity.setModifiedDate(new Date());
            transactionEntity.setModifiedBy(SecurityUtils.getPrincipal().getUsername());
            transactionEntity.setCode(transactionExits.getCode());
        }
        else{
            CustomerEntity customerEntity = customerRepository.findById(transactionDTO.getCustomerId()).get();
            transactionEntity.setCustomer(customerEntity);
            transactionEntity.setCreatedDate(new Date());
            transactionEntity.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
            transactionEntity.setCode(transactionDTO.getCode());
        }
        transactionEntity.setNote(transactionDTO.getTransactionDetail());
        transactionRepository.save(transactionEntity);
    }
}
