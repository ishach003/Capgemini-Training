package com.example.hibernate;

import com.example.hibernate.daoimpl.CustomerDAOImpl;
import com.example.hibernate.entity.Customer;
import com.example.hibernate.entity.Order;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        CustomerDAOImpl dao = new CustomerDAOImpl();

        Customer customer = new Customer();
        customer.setCustomerName("Isha");
        customer.setEmail("isha@gmail.com");
        customer.setGender("Female");
        customer.setPhone(9876543210L);
        customer.setRegistrationDate(LocalDate.now());

        Order order = new Order();
        order.setOrderNumber("ORD101");
        order.setProductName("Laptop");
        order.setQuantity(1);
        order.setPrice(65000);
        order.setOrderDate(LocalDate.now());

        customer.setOrder(order);

        System.out.println(dao.saveCustomer(customer));
    }
}