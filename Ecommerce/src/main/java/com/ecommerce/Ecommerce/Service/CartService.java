package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.CartItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.CartRequestDTO;
import com.ecommerce.Ecommerce.JPA.CartItemRepository;
import com.ecommerce.Ecommerce.JPA.CartRepository;
import com.ecommerce.Ecommerce.JPA.CustomerRepository;
import com.ecommerce.Ecommerce.JPA.ProductRepository;
import com.ecommerce.Ecommerce.Model.Cart;
import com.ecommerce.Ecommerce.Model.CartItem;
import com.ecommerce.Ecommerce.Model.Customer;
import com.ecommerce.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartItemRepository cartItemRepository;


    public Object postCart(CartRequestDTO cartRequestDTO) {
        Customer customer = customerRepository.findById(cartRequestDTO.getCustomerId()).orElse(null);
        Cart cart = new Cart();
        cart.setCartId(cart.getCartId());
        cart.setCustomer(customer);
        cart = cartRepository.save(cart);
        return cart;
    }

    public Object postCartItem(CartItemRequestDTO cartItemRequestDTO) {
        if (cartItemRequestDTO.getCartId() != 0) {
            Cart cart = cartRepository.findById(cartItemRequestDTO.getCartId()).orElse(null);
            Customer customer = customerRepository.findById(cartItemRequestDTO.getCustomerId()).orElse(null);
            Product product = productRepository.findById(cartItemRequestDTO.getProductId()).orElse(null);
            CartItem cartItem = new CartItem();
            cartItem.setCustomer(customer);
            cartItem.setProduct(product);
            cartItem.setCartItemId(cartItem.getCartItemId());
            cartItem.setCartId(cartItemRequestDTO.getCartId());
            cartItem.setCustomerId(cartItemRequestDTO.getCustomerId());
            cartItem.setProductId(cartItemRequestDTO.getProductId());
            cartItem.setItemPrice(cartItem.getProduct().getProductPrice() * cartItem.getProduct().getProductQuantity());
            cartItem = cartItemRepository.save(cartItem);

        } else {
            return "Enter the cartId to add";
        }
        return "item added to cart";
    }
}