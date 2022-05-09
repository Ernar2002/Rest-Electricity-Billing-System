package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "admin")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Admin extends BaseEntity {

    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Password can not be empty")
    private String pass;
}
