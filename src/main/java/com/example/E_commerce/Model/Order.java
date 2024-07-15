package com.example.E_commerce.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_table")
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

    public Order() {
    }

    public Order(long userid, long itemId, long quantity) {
        this.userId = userid;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
