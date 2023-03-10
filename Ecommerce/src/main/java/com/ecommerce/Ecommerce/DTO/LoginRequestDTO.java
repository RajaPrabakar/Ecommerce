package com.ecommerce.Ecommerce.DTO;

import com.ecommerce.Ecommerce.Model.Customer;

public class LoginRequestDTO
{
    private String userName;
    private String password;
    private Customer customer;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
