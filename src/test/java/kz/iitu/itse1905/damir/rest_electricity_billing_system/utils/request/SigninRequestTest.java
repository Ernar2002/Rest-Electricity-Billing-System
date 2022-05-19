package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SigninRequestTest {
    SigninRequest signinRequest = new SigninRequest("email", "password");

    @Test
    void testSetEmail() {
        signinRequest.setEmail("email");
    }

    @Test
    void testSetPassword() {
        signinRequest.setPassword("password");
    }

    @Test
    void testEquals() {
        boolean result = signinRequest.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = signinRequest.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = signinRequest.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = signinRequest.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme