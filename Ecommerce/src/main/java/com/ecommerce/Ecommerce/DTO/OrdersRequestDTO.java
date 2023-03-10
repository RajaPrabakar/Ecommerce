package com.ecommerce.Ecommerce.DTO;

import com.ecommerce.Ecommerce.Model.Customer;

import java.time.LocalDateTime;

public class OrdersRequestDTO
{
    private int orderId;
    private int customerId;
    private Customer customer;


    private String status;

    private LocalDateTime expectedDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDateTime expectedDate) {
        this.expectedDate = expectedDate;
    }


}
