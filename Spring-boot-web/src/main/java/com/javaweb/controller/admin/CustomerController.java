package com.javaweb.controller.admin;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.Status;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import com.javaweb.service.TransactionService;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/admin/customer-list")
    public ModelAndView customer(@ModelAttribute("customerDTO") CustomerSearchRequest csr, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        DisplayTagUtils.of(request, csr);
        mav.addObject("staffs", iUserService.getStaffs());
        mav.addObject("status", Status.getStatus());
        List<CustomerEntity> listCustomer = new ArrayList<>();
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            csr.setStaffId(staffId);
            listCustomer = iCustomerService.findCustomer(csr, PageRequest.of(csr.getPage() - 1, csr.getMaxPageItems()));
        }
        else{
            listCustomer = iCustomerService.findCustomer(csr, PageRequest.of(csr.getPage() - 1, csr.getMaxPageItems()));
        }
        csr.setListResult(listCustomer);
        csr.setTotalItems(iCustomerService.countCustomer(csr));
        return mav;
    }

    @GetMapping("/admin/customer-edit")
    public ModelAndView customer(@ModelAttribute("customerDTO") CustomerDTO csr) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("status", Status.getStatus());
        return mav;
    }


    @GetMapping("/admin/customer-edit-{ids}")
    public ModelAndView editCustomer(@PathVariable Long ids) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerDTO customerDTO = customerService.findCustomerById(ids);
        mav.addObject("customerDTO", customerDTO);
        mav.addObject("status", Status.getStatus());
        mav.addObject("transactionType", TransactionType.type());
        mav.addObject("transactionCSKH", transactionService.findByCodeAndCustomerId("CSKH", ids));
        mav.addObject("transactionDDX", transactionService.findByCodeAndCustomerId("DDX", ids));
        return mav;
    }

}
