package kz.iitu.itse1905.damir.rest_electricity_billing_system.repository;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> getComplaintsByUser(User user);
}
