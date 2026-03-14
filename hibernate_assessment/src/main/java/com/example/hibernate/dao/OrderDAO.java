package com.example.hibernate.dao;

import com.example.hibernate.entity.Order;

public interface OrderDAO {

    String saveOrder(Order order);

    String updateOrder(Order order);

    String deleteOrderById(int id);

    Order getOrderById(int id);
}