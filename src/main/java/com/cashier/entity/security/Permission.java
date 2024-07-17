package com.cashier.entity.security;

import com.cashier.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "c_security_permission")
@Data
public class Permission extends BaseEntity {

    @Size(max = 100)
    @NotEmpty(message = "label tidak boleh kosong")
    @Column(name = "permission_label", nullable = false,length = 100)
    private String permissionLabel;

    @Size(max = 100)
    @NotEmpty(message = "value tidak boleh kosong")
    @Column(name = "permission_value", nullable = false, length = 100)
    private String permissionValue;
}