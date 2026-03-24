package com.example.stockmanagement.controller;

import com.example.stockmanagement.entity.Product;
import com.example.stockmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @GetMapping("/name/{name}")
    public List<Product> byName(@PathVariable String name) {
        return service.searchByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return service.searchByCategory(category);
    }

    @GetMapping("/company/{company}")
    public List<Product> byCompany(@PathVariable String company) {
        return service.searchByCompany(company);
    }
}