package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.enums.EStatusPayment;
import lombok.*;

import javax.persistence.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;

import java.util.Date;

@Entity
@Table(name = "billings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Billing extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cust_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "bill_amount", nullable = false, insertable = false, updatable = false)
    private double billAmount;

    @Column(name = "paid_amount", nullable = false, insertable = false, updatable = false)
    private double paidAmount;

    @Column(name = "excess_amount", nullable = false, insertable = false, updatable = false)
    private double excessAmount;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "payment_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatusPayment status;

    @OneToOne(mappedBy = "billing")
    private Invoice invoice;
}
