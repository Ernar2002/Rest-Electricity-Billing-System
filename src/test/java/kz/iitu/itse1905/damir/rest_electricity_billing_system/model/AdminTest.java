package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

class AdminTest {
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Admin admin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetName() {
        admin.setName("name");
    }

    @Test
    void testSetEmail() {
        admin.setEmail("email");
    }

    @Test
    void testSetPass() {
        admin.setPass("pass");
    }

    @Test
    void testEquals() {
        boolean result = admin.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = admin.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = admin.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = admin.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Admin.AdminBuilder result = Admin.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        admin.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        admin.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime());
    }

    @Test
    void testSetActive() {
        admin.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme