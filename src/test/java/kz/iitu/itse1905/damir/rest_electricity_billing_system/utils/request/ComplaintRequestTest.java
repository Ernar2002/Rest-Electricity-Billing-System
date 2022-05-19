package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComplaintRequestTest {
    ComplaintRequest complaintRequest = new ComplaintRequest("text");

    @Test
    void testSetText() {
        complaintRequest.setText("text");
    }

    @Test
    void testEquals() {
        boolean result = complaintRequest.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = complaintRequest.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = complaintRequest.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = complaintRequest.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme