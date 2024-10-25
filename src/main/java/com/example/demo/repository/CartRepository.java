package com.example.demo.repository;

import com.example.demo.model.Cart;
import com.example.demo.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomer(Customer customer);
}
