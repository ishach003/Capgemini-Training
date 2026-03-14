package com.example.hibernate.dao;

import com.example.hibernate.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    String deleteCustomerById(int id);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(String email);
}