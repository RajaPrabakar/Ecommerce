package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.CustomerRequestDTO;
import com.ecommerce.Ecommerce.Model.Customer;
import com.ecommerce.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Validated
@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;



    @PostMapping(value = "/create-customer")
    public ResponseEntity<Object> createCustomers(@Valid @RequestBody CustomerRequestDTO customerRequestDTO)
    {
        Customer customer = customerService.postCustomer(customerRequestDTO);
        return ResponseEntity.ok(customer);

    }
}
