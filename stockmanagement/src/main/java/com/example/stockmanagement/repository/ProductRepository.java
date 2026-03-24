package com.example.stockmanagement.repository;

import com.example.stockmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByCompany(String company);
}