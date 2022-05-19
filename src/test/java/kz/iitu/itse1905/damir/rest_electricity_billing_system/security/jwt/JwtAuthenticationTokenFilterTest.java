package kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Set;

import static org.mockito.Mockito.*;

class JwtAuthenticationTokenFilterTest {
    @Mock
    JwtUtil jwtUtil;
    @Mock
    Log logger;
    @Mock
    Environment environment;
    @Mock
    ServletContext servletContext;
    @Mock
    FilterConfig filterConfig;
    @Mock
    Set<String> requiredProperties;
    @InjectMocks
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDoFilter() throws ServletException, IOException {
        when(jwtUtil.getAuthentication(anyString())).thenReturn(null);
        when(jwtUtil.resolveToken(any())).thenReturn("resolveTokenResponse");
        when(jwtUtil.validateToken(anyString())).thenReturn(true);

        jwtAuthenticationTokenFilter.doFilter(null, null, null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme