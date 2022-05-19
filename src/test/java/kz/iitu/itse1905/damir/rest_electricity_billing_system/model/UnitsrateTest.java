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

class UnitsrateTest {
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Unitsrate unitsrate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetTwohundred() {
        unitsrate.setTwohundred(0);
    }

    @Test
    void testSetFivehundred() {
        unitsrate.setFivehundred(0);
    }

    @Test
    void testSetThousand() {
        unitsrate.setThousand(0);
    }

    @Test
    void testEquals() {
        boolean result = unitsrate.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = unitsrate.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = unitsrate.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = unitsrate.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Unitsrate.UnitsrateBuilder result = Unitsrate.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        unitsrate.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        unitsrate.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime());
    }

    @Test
    void testSetActive() {
        unitsrate.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme