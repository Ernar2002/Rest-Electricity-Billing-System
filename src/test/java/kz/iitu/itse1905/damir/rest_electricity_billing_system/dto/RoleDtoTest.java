package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

class RoleDtoTest {
    RoleDto roleDto = new RoleDto();

    @Test
    void testFromRole() {
        RoleDto result = RoleDto.fromRole(new Role("name", new HashSet<User>(Arrays.asList(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(null)), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))))));
        Assertions.assertEquals(new RoleDto(), result);
    }

    @Test
    void testSetId() {
        roleDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetName() {
        roleDto.setName("name");
    }

    @Test
    void testEquals() {
        boolean result = roleDto.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = roleDto.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = roleDto.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = roleDto.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme