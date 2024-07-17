package com.cashier.entity;

import com.cashier.entity.security.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Outlet extends BaseEntity{

    private String name;
    private String address;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
