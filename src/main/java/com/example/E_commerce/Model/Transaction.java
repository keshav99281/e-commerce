package com.example.E_commerce.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_table")
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

    public Transaction() {
    }

    public Transaction(long userId, long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
