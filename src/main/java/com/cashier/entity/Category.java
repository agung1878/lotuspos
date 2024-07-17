package com.cashier.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category extends BaseEntity{

    private String name;
    private String description;
    private List<ItemLibrary> itemStocks = new ArrayList<ItemLibrary>();

}
