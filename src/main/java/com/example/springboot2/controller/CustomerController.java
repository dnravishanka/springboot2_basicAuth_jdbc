package com.example.springboot2.controller;

import com.example.springboot2.dto.CustomerDto;
import com.example.springboot2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public void customerSave(@RequestBody CustomerDto dto) {
        customerService.saveCustomer(dto);
    }

    @PutMapping
    public void customerUpdate(@RequestBody CustomerDto dto) {
        customerService.updateCustomer(dto);

    }

    @DeleteMapping
    public void customerDelete(@RequestParam String id) {
        customerService.deleteCustomer(id);


    }

    @GetMapping("/all")
    public List<CustomerDto> getAllCustomer() {
        List<CustomerDto> allCustomers = customerService.getAllCustomers();


        return allCustomers;

    }
    @GetMapping("/id")
    public CustomerDto customerSearchById(@RequestParam String id) {
        CustomerDto customerDto = customerService.searchCustomerByID(id);
        return customerDto;

    }

    @GetMapping("/address")
    public CustomerDto customerSearchByAddress(String address) {
        CustomerDto customerDto = customerService.SearchCustomerByAddress(address);
        return customerDto;

    }

    @GetMapping("/name")
    public CustomerDto customerSearchByName(String name) {
        CustomerDto customerDto = customerService.SearchCustomerByName(name);
        return customerDto;
    }
}