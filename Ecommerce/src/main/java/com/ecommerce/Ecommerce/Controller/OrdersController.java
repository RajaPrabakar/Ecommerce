package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.OrderItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.OrdersRequestDTO;
import com.ecommerce.Ecommerce.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController
{
    @Autowired
    private OrdersService ordersService;


    @PostMapping(value = "/place-order")
    public ResponseEntity<Object> createOrder(@RequestBody OrdersRequestDTO ordersRequestDTO)
    {
        Object obj = ordersService.placeOrder(ordersRequestDTO);
        return ResponseEntity.ok(obj);
    }

}
