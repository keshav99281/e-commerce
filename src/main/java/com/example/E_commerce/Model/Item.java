package com.example.E_commerce.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "items_table")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private long itemId;
    @Column(name = "itemName", unique = true)
    private String itemName;
    private BigDecimal price;
    private long quantity;
}
