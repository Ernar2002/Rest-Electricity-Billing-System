package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bill")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Bill extends BaseEntity {

    @Column(nullable = false)
    private int units;

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EStatus status;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy="bill")
    private Set<Transaction> transactions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private User user;

}
