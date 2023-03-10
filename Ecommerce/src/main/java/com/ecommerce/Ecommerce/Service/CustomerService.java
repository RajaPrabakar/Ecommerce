package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.CustomerRequestDTO;
import com.ecommerce.Ecommerce.JPA.CustomerRepository;
import com.ecommerce.Ecommerce.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;


    public Customer postCustomer(CustomerRequestDTO customerRequestDTO)
    {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setUserName(customerRequestDTO.getUserName());
        customer.setPassword(customerRequestDTO.getPassword());
        customer.setGender(customerRequestDTO.getGender());
        customer.setMobileNumber(customerRequestDTO.getMobileNumber());
        customer.setEmailId(customerRequestDTO.getEmailId());
        customer.setAddress(customerRequestDTO.getAddress());
        customer=customerRepository.save(customer);
        return customer;
    }








}
