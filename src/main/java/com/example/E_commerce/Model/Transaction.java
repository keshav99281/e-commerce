package com.example.E_commerce.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_table")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private long transactionId;
    @Column(name = "userId")
    private long userId;
    @Column(name = "orderId")
    private long orderId;
    @Column(name = "price")
    private BigDecimal price;
}
