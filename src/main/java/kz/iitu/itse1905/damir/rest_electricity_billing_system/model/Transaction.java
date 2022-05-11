package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Transaction extends BaseEntity {

    @Column(nullable = false)
    private double payable;

    @Column(name = "pdate")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date pDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bill_id", nullable=false)
    @JsonIgnore
    private Bill bill;
}
