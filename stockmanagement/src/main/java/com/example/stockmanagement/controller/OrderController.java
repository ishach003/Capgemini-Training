package com.example.stockmanagement.controller;

import com.example.stockmanagement.entity.Order;
import com.example.stockmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bill")
    public Order generateBill(@RequestBody Map<Integer, Integer> cart) {
        return service.generateBill(cart);
    }
}