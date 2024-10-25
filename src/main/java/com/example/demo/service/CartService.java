package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByCustomer(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }
}
