package com.javaweb.service;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionEntity> findByCodeAndCustomerId(String code, Long id);


    void addTransaction(TransactionDTO transactionDTO);
}
