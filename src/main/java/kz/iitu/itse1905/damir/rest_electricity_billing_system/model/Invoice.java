package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import java.sql.Date;

@Entity
@Table(name = "invoces")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invoice extends BaseEntity{

    @Column(name = "consumption_init", nullable = false)
    private double consumptionInit;

    @Column(name = "reading_date", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date readingDate;

    @Column(name = "bill_amount", nullable = false)
    private double billAmount;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false, insertable = false, updatable = false)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tariff_id", referencedColumnName = "id")
    private Tariff tariff;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_id", referencedColumnName = "id")
    private Billing billing;

    @ManyToOne
    @JoinColumn(name="electricityboard_id", nullable=false, insertable = false, updatable = false)
    private ElectricityBoard electricityBoard;

}
