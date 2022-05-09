package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<Account> accounts;
}