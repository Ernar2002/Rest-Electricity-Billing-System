package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Complaint extends BaseEntity {

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

}
