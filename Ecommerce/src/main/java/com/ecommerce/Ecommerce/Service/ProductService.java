package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.ProductRequestDTO;
import com.ecommerce.Ecommerce.JPA.ProductRepository;
import com.ecommerce.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public Object postProducts(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductSpecification(productRequestDTO.getProductSpecification());
        product.setProductQuantity(productRequestDTO.getProductQuantity());
        product=productRepository.save(product);
        return "Product is Added";
    }



}
