package com.example.E_commerce.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items_table")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private long itemId;
    @Column(name = "itemName", unique = true)
    private String itemName;
    private BigDecimal price;
    private long quantity;

    public Item() {
    }

    public Item(String itemName, BigDecimal price, long quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
