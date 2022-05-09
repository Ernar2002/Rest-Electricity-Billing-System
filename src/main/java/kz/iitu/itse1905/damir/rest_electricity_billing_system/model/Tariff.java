package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;

@Entity
@Table(name = "tariffs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tariff extends BaseEntity {

    @Column(name = "tariff_type")
    private String tariffType;

    @Column(name = "tariff_description")
    private String tariffDescription;

    @OneToOne(mappedBy = "tariff")
    private Invoice invoice;


}
