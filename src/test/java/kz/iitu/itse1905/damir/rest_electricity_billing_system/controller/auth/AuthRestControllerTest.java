package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.auth;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt.JwtUtil;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.SigninRequest;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.SignupRequest;
import java.util.Set;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response.MessageResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import static org.mockito.Mockito.*;

class AuthRestControllerTest {
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    JwtUtil jwtUtil;
    @Mock
    UserService userService;
    @InjectMocks
    AuthRestController authRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        ResponseEntity<?> result = authRestController.registerUser(new SignupRequest("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address"));
        userService.save(user);
        when(userService.findByEmail("email")).thenReturn(user);

        MessageResponse expected = new MessageResponse("User created");
        Assertions.assertEquals(expected, result.getBody());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme