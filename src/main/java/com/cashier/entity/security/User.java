package com.cashier.entity.security;

import com.cashier.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.flywaydb.core.internal.util.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@Table(name = "c_security_user")
@Entity
public class User extends BaseEntity {

    @Size(max = 100)
    @NotEmpty(message = "Username tidak boleh dikosongkan")
    @Column(nullable = false, unique = true)
    private String username;

    private Boolean active = Boolean.FALSE;

    @JsonIgnore
    @OneToOne(mappedBy = "user", optional = true, orphanRemoval = true)
    @Cascade({CascadeType.ALL})
    private UserPassword userPassword;

    @Transient @JsonIgnore
    private String password;

    @NotNull(message = "Role tidak boleh dikosongkan")
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    private String companyName;
    private String name;

    private String type;

    @Override
    public String selectionText(){
        String result = this.username;

        if(StringUtils.hasText(this.name)) {
            result = this.name;
        }

        if(StringUtils.hasText(this.companyName)) {
            return result + " - " + this.companyName;
        } else {
            return result;
        }
    }

}
