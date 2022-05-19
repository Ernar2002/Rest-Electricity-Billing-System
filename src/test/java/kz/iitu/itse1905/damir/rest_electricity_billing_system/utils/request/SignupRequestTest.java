package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SignupRequestTest {
    SignupRequest signupRequest = new SignupRequest("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address");

    @Test
    void testSetEmail() {
        signupRequest.setEmail("email");
    }

    @Test
    void testSetPassword() {
        signupRequest.setPassword("password");
    }

    @Test
    void testSetFirstName() {
        signupRequest.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        signupRequest.setLastName("lastName");
    }

    @Test
    void testSetPhoneNumber() {
        signupRequest.setPhoneNumber("phoneNumber");
    }

    @Test
    void testSetIin() {
        signupRequest.setIin("iin");
    }

    @Test
    void testSetAddress() {
        signupRequest.setAddress("address");
    }

    @Test
    void testEquals() {
        boolean result = signupRequest.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = signupRequest.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = signupRequest.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = signupRequest.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme