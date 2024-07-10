package com.example.E_commerce.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_table")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long transaction_id;
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "order_id")
    private long order_id;
    @Column(name = "price")
    private BigDecimal price;

    public Transaction() {
    }

    public Transaction(long user_id, long order_id) {
        this.user_id = user_id;
        this.order_id = order_id;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
