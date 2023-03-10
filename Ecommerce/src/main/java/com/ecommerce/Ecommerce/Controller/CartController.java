package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.CartItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.CartRequestDTO;
import com.ecommerce.Ecommerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController
{
    @Autowired
    private CartService cartService;


    @PostMapping(value = "/create-cart")
    public ResponseEntity<Object> createCart(@RequestBody CartRequestDTO cartRequestDTO)
    {
        Object obj = cartService.postCart(cartRequestDTO);
        return ResponseEntity.ok(obj);
    }


    @PostMapping(value = "/create-cart-item")
    public ResponseEntity<Object> createCartItem(@RequestBody CartItemRequestDTO cartItemRequestDTO)
    {
        Object obj = cartService.postCartItem(cartItemRequestDTO);
        return ResponseEntity.ok(obj);
    }
}
