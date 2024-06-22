package com.javaweb.api.admin;


import com.javaweb.model.dto.AssigmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private TransactionService transactionService;


    @PostMapping("")
    public String addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return "oke";
    }


    @GetMapping("/{id}/staffs")
    public ResponseDTO findAllStaffs(@PathVariable Long id) {
        ResponseDTO responseDTO = customerService.listStaffs(id);
        return responseDTO;
    }

    @PutMapping("")
    public void assigmentCustomer(@RequestBody AssigmentCustomerDTO assigmentCustomerDTO) {
        customerService.assigmentCustomer(assigmentCustomerDTO);
    }

    @DeleteMapping("/{ids}")
    public void deleteCustomer(@PathVariable List<Long> ids) {
        customerService.deleteCustomer(ids);
    }

    @PostMapping("/transactional")
    public void transactional(@RequestBody TransactionDTO transactionDTO) {
        transactionService.addTransaction(transactionDTO);
    }

}
