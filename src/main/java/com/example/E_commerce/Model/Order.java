package com.example.E_commerce.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long order_id;
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "item_id")
    private long item_id;
    private long quantity;
    @Column(name = "order_price")
    private BigDecimal order_price;

    public Order() {
    }

    public Order(long userid, long itemId, long quantity) {
        this.user_id = userid;
        this.item_id = itemId;
        this.quantity = quantity;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrder_price() {
        return order_price;
    }

    public void setOrder_price(BigDecimal order_price) {
        this.order_price = order_price;
    }
}
