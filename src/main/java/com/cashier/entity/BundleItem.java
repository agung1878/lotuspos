package com.cashier.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class BundleItem extends BaseEntity{

    private ItemLibrary item;
    private int quantity;

}
