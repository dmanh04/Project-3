package com.javaweb.service;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.AssigmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<CustomerEntity> findCustomer(CustomerSearchRequest customerSearchRequest, Pageable pageable);

    int countCustomer(CustomerSearchRequest csr);

    CustomerDTO findCustomerById(Long id);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    ResponseDTO listStaffs(Long id);

    void assigmentCustomer(AssigmentCustomerDTO assigmentCustomerDTO);

    void deleteCustomer(List<Long> id);

}
