package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.ETariff;
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

class BillRequestTest {
    //Field tariff of type ETariff - was not mocked since Mockito doesn't mock enums
    @Mock
    Date startDate;
    @Mock
    Date endDate;
    @InjectMocks
    BillRequest billRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetUnits() {
        billRequest.setUnits(0);
    }

    @Test
    void testSetTariff() {
        billRequest.setTariff(ETariff.TWOHUNDRED);
    }

    @Test
    void testSetStartDate() {
        billRequest.setStartDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 58).getTime());
    }

    @Test
    void testSetEndDate() {
        billRequest.setEndDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 58).getTime());
    }

    @Test
    void testEquals() {
        boolean result = billRequest.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = billRequest.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = billRequest.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = billRequest.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme