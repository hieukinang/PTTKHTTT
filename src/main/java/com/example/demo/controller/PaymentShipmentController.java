package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentShipmentController {

    @GetMapping("/payment-shipment")
    public String showPaymentShipment() {
        return "paymentShipment"; // Trả về tên template paymentShipment.html
    }
}
