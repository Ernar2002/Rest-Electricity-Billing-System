package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import java.sql.Date;

@Entity
@Table(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Feedback extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cust_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    private String feedback;

    @Column(name = "feedback_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date feedbackDate;
}
