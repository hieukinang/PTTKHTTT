package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Customer;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session) {
        // Lấy tên khách hàng từ session
        String customerName = (String) session.getAttribute("customerName");

        if (customerName != null) {
            // Giả sử bạn có phương thức lấy thông tin Customer từ tên người dùng
            Customer customer = customerService.findByUsername(customerName);

            // Lấy giỏ hàng của khách hàng đăng nhập
            Cart cart = cartService.getCartByCustomer(customer);
            model.addAttribute("cart", cart);
        } else {
            // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
            return "redirect:/login";
        }

        return "cart";
    }

}
