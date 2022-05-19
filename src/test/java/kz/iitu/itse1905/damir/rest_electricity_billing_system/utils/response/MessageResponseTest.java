package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageResponseTest {
    MessageResponse messageResponse = new MessageResponse("message");

    @Test
    void testSetMessage() {
        messageResponse.setMessage("message");
    }

    @Test
    void testEquals() {
        boolean result = messageResponse.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = messageResponse.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = messageResponse.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = messageResponse.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme