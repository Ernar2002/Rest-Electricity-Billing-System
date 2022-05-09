package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends BaseEntity {

    @OneToOne(mappedBy = "customer")
    private Account account;

    @Column(name = "cust_name", nullable = false)
    private String customerName;

    @Column(nullable = false)
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Password can not be empty")
    private String password;

    private String address;
    private String country;
    private String city;
}
