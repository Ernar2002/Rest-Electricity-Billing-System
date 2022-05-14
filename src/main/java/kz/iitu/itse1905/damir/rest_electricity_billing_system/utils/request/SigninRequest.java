package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import lombok.Data;

@Data
public class SigninRequest {
    private String email;
    private String password;
}
