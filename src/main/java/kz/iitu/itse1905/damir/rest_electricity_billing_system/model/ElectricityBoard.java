package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import java.util.Set;

@Entity
@Table(name = "electricity_board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ElectricityBoard extends BaseEntity {

    @Column(name = "electricity_board")
    private String electricityBoard;

    private String logo;
    private String note;
}
