package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.details;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

class UserDetailsTest {
    UserDetails userDetails = new UserDetails();

    @Test
    void testFromUser() {
        UserDetails result = UserDetails.fromUser(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
        Assertions.assertEquals(new UserDetails(), result);
    }

    @Test
    void testSetEmail() {
        userDetails.setEmail("email");
    }

    @Test
    void testSetFirstName() {
        userDetails.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        userDetails.setLastName("lastName");
    }

    @Test
    void testSetPhoneNumber() {
        userDetails.setPhoneNumber("phoneNumber");
    }

    @Test
    void testSetIin() {
        userDetails.setIin("iin");
    }

    @Test
    void testSetAddress() {
        userDetails.setAddress("address");
    }

    @Test
    void testEquals() {
        boolean result = userDetails.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = userDetails.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = userDetails.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = userDetails.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme