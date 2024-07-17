package com.cashier.entity.security;

import com.cashier.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "c_security_reset_password")
@Data
public class ResetPassword extends BaseEntity {
    @Size(max = 100)
    @NotEmpty(message = "Token tidak boleh dikosongkan")
    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
