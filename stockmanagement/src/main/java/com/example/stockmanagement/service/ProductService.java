package com.example.stockmanagement.service;

import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product newProduct) {
        Product p = repo.findById(id).orElseThrow();
        p.setName(newProduct.getName());
        p.setCategory(newProduct.getCategory());
        p.setCompany(newProduct.getCompany());
        p.setQuantity(newProduct.getQuantity());
        p.setPrice(newProduct.getPrice());
        return repo.save(p);
    }

    public List<Product> searchByName(String name) {
        return repo.findByName(name);
    }

    public List<Product> searchByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> searchByCompany(String company) {
        return repo.findByCompany(company);
    }
}