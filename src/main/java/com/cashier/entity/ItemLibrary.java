package com.cashier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ItemLibrary extends BaseEntity{

    private String name;
    private String description;
    private String itemImage;
    private int stock;
    private BigDecimal price;
}
