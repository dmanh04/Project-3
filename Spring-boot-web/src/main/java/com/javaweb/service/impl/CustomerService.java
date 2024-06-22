package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.converter.UserConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssigmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository; ;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<CustomerEntity> findCustomer(CustomerSearchRequest customerSearchRequest, Pageable pageable) {
        List<CustomerEntity> result = customerRepository.findCustomer(customerSearchRequest, pageable);
        return result;
    }

    @Override
    public int countCustomer(CustomerSearchRequest csr) {
        int result = customerRepository.countCustomer(csr);
        return result;
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        return customerConverter.toCustomerDTO(customerEntity);
    }


    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.toCustomerEntity(customerDTO);
        if(customerEntity.getId() != null){
            CustomerEntity customerEntityExits = customerRepository.findById(customerEntity.getId()).get();
            customerEntity.setModifiedDate(new Date());
            customerEntity.setModifiedBy(SecurityUtils.getPrincipal().getUsername());
            customerEntity.setCreatedDate(customerEntityExits.getCreatedDate());
            customerEntity.setCreatedBy(customerEntityExits.getCreatedBy());
            customerEntity.setUsers(customerEntityExits.getUsers());
        }
        else{
            customerEntity.setCreatedDate(new Date());
            String k = SecurityContextHolder.getContext().getAuthentication().getName();
            if(k.equals("anonymousUser")){
                customerEntity.setCreatedBy(k);
                customerEntity.setStatus("Chưa xử lý");
            }
            else{
                customerEntity.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
            }
        }
        customerEntity.setIsActive(1);
        customerRepository.save(customerEntity);
        return customerConverter.toCustomerDTO(customerEntity);
    }

    @Override
    public ResponseDTO listStaffs(Long id) {
        List<UserEntity> userEntities = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> userEntitiesStaff = userRepository.findByCustomers_Id(id);
        List<StaffResponseDTO> staffResponseDTOs = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
             StaffResponseDTO staffResponseDTO = userConverter.convertToStaffResponseDTO(userEntity);
            if(userEntitiesStaff.contains(userEntity)) {
                staffResponseDTO.setChecked("checked");
            }
            staffResponseDTOs.add(staffResponseDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOs);
        responseDTO.setMessage("oke");
        return responseDTO;
    }

    @Override
    public void assigmentCustomer(AssigmentCustomerDTO assigmentCustomerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(assigmentCustomerDTO.getCustomerId()).get();
        List<UserEntity> userEntities = userRepository.findByIdIn(assigmentCustomerDTO.getStaffs());
        customerEntity.setUsers(userEntities);
        customerRepository.save(customerEntity);
    }

    @Override
    public void deleteCustomer(List<Long> id) {
        for(Long items : id){
            CustomerEntity customerEntity = customerRepository.findById(items).get();
            customerEntity.setIsActive(0);
            customerRepository.save(customerEntity);
        }
    }
}
