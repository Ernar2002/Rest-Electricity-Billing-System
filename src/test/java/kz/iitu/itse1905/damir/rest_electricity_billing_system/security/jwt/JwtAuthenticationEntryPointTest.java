package kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt;

import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

class JwtAuthenticationEntryPointTest {
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint = new JwtAuthenticationEntryPoint();

    @Test
    void testCommence() throws ServletException, IOException {
        jwtAuthenticationEntryPoint.commence(null, null, new JwtAuthenticationException("msg", null));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme