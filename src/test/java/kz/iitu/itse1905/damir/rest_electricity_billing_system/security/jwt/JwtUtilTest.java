package kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Role;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.*;

class JwtUtilTest {
    @Mock
    UserDetailsService userDetailsService;
    @Mock
    UserService userService;
    @InjectMocks
    JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder result = jwtUtil.bCryptPasswordEncoder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testInit() {
        jwtUtil.init();
    }

    @Test
    void testGetUsername() {
        String result = jwtUtil.getUsername("token");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetAuthentication() {
        Authentication result = jwtUtil.getAuthentication("token");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateToken() {
        when(userService.findByEmail(anyString())).thenReturn(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(null)), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(null))));

        String result = jwtUtil.createToken("username");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testResolveToken() {
        String result = jwtUtil.resolveToken(null);
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testValidateToken() {
        boolean result = jwtUtil.validateToken("token");
        Assertions.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme