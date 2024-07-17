package com.cashier.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BundlePackage extends BaseEntity{

    private String bundleName;
    private String bundleDescription;
    private List<BundleItem> bundleItems = new ArrayList<>();
    private BigDecimal price;
    private boolean status = Boolean.FALSE;

}
