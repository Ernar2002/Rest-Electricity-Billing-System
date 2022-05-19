package kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.mockito.Mockito.*;

class JwtUserDetailsTest {
    @Mock
    Collection<? extends GrantedAuthority> authorities;
    @InjectMocks
    JwtUserDetails jwtUserDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIsAccountNonExpired() {
        boolean result = jwtUserDetails.isAccountNonExpired();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsAccountNonLocked() {
        boolean result = jwtUserDetails.isAccountNonLocked();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsCredentialsNonExpired() {
        boolean result = jwtUserDetails.isCredentialsNonExpired();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsEnabled() {
        boolean result = jwtUserDetails.isEnabled();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testEquals() {
        boolean result = jwtUserDetails.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = jwtUserDetails.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = jwtUserDetails.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = jwtUserDetails.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme