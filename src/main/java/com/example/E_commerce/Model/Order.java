package com.example.E_commerce.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_table")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private long orderId;
    @Column(name = "userId")
    private long userId;
    @Column(name = "itemId")
    private long itemId;
    private long quantity;
    @Column(name = "orderPrice")
    private BigDecimal orderPrice;
}
