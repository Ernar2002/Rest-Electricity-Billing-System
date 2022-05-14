package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String iin;
    private String address;
}
