package com.example.cursojava.controller;

import com.example.cursojava.entity.Customer;
import com.example.cursojava.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer-management")
@Api(
    tags = {"customer-management-service"}
)
public class CustomerController {
    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @ApiOperation(
        value = "Get all customers records",
        notes = "Use this resource to get all customers information.",
        tags = {"customer-management-service"}
    )
    @GetMapping("/customers")
    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @ApiOperation(
        value = "Create a new customer record",
        notes = "Use this resource to add a new todo record.",
        tags = {"customer-management-service"}
    )
    @PostMapping("/customers")
    Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
