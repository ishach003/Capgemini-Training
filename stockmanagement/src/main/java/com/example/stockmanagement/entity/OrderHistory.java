package com.example.stockmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_history_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;
    private int productId;
}