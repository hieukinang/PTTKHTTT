package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Trả về trang login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                    @RequestParam String password, 
                    Model model, 
                    HttpSession session) {
        Customer customer = customerService.login(username, password);
        if (customer != null) {
            session.setAttribute("customerName", customer.getUsername()); // Lưu tên khách hàng vào session
            session.setAttribute("customerId", customer.getId());
            return "redirect:/home"; // Chuyển hướng đến /home
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }
    }
}
