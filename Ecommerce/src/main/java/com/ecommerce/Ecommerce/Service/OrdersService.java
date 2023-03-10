package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.OrderItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.OrdersRequestDTO;
import com.ecommerce.Ecommerce.JPA.*;
import com.ecommerce.Ecommerce.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;


    public Object placeOrder(OrdersRequestDTO ordersRequestDTO)
    {
        if(ordersRequestDTO.getCustomerId()!=0) {
            List<CartItem> cartItemList = cartItemRepository.findByCustomer_CustomerId(ordersRequestDTO.getCustomerId());
            Orders orders = new Orders();
            double overallTotal = 0.0;
            for (CartItem cartItem : cartItemList) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrders(orders);
                orderItem.setName(cartItem.getProduct().getProductName());
                orderItem.setPrice(cartItem.getProduct().getProductPrice());
                orderItem.setQuantity(cartItem.getProduct().getProductQuantity());
                orderItem.setTotal(cartItem.getItemPrice());
                Product product = productRepository.findById(cartItem.getCartId()).orElse(null);
                product.setProductQuantity(product.getProductQuantity() - orderItem.getQuantity());
                overallTotal = overallTotal + orderItem.getTotal();
                orders.setStatus("Ordered");
                orders.setExpectedDate(orders.getExpectedDate());
                orders.setOverallTotal(overallTotal);
                orders = ordersRepository.save(orders);
                orderItem = orderItemRepository.save(orderItem);
                productRepository.save(product);
            }
        }else {
            return "you have to Enter the customerId";
        }
        return "Ordered";
    }
}
