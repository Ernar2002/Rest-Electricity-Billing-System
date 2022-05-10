package kz.iitu.itse1905.damir.rest_electricity_billing_system.repository;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
