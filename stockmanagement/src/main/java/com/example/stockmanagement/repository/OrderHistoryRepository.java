package com.example.stockmanagement.repository;

import com.example.stockmanagement.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
}