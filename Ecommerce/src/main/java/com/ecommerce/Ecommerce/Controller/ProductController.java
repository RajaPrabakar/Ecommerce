package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.ProductRequestDTO;
import com.ecommerce.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{

    @Autowired
    private ProductService productService;



    @PostMapping(value = "/add-product")
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        Object obj = productService.postProducts(productRequestDTO);
        return ResponseEntity.ok(obj);
    }
}
