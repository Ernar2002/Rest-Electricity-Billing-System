package kz.iitu.itse1905.damir.rest_electricity_billing_system.model.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.enums.EActive;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "active")
    private EActive active;
}