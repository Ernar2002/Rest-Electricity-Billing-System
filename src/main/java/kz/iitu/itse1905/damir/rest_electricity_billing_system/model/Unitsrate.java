package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unitsrate")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Unitsrate extends BaseEntity {

    private int twohundred;

    private int fivehundred;

    private int thousand;
}
