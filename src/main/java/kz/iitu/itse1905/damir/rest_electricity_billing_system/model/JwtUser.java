package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class JwtUser {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String iin;
    private String address;
    private Set<Role> roles;
}