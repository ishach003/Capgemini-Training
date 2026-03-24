package com.example.stockmanagement.service;

import com.example.stockmanagement.entity.*;
import com.example.stockmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderHistoryRepository historyRepo;

    private static final double GST = 0.18;

    public Order generateBill(Map<Integer, Integer> cart) {

        double total = 0;
        Order order = new Order();

        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

            Product product = productRepo.findById(entry.getKey()).orElseThrow();
            int qty = entry.getValue();

            if (product.getQuantity() < qty) {
                throw new RuntimeException("Not enough stock for " + product.getName());
            }

            total += product.getPrice() * qty;

            // reduce stock
            product.setQuantity(product.getQuantity() - qty);
            productRepo.save(product);
        }

        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total + total * GST);

        Order savedOrder = orderRepo.save(order);

        // save order history
        for (Integer productId : cart.keySet()) {
            OrderHistory history = new OrderHistory();
            history.setOrderId(savedOrder.getId());
            history.setProductId(productId);
            historyRepo.save(history);
        }

        return savedOrder;
    }
}