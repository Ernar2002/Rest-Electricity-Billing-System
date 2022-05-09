package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_roles",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "electricityboard_id", referencedColumnName = "id")
    private ElectricityBoard electricityBoard;

    @OneToMany(mappedBy="account")
    private Set<Invoice> invoices;
}
