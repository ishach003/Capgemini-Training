package com.example.stockmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalPrice;
    private double totalPriceWithGst;
}