package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class BillDtoTest {
    //Field status of type EStatus - was not mocked since Mockito doesn't mock enums
    @Mock
    Date startDate;
    @Mock
    Date endDate;
    @Mock
    Set<TransactionDto> transactions;
    @InjectMocks
    BillDto billDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFromBill() {
        BillDto result = BillDto.fromBill(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))));
        Assertions.assertEquals(new BillDto(), result);
    }

    @Test
    void testSetId() {
        billDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetUnits() {
        billDto.setUnits(0);
    }

    @Test
    void testSetAmount() {
        billDto.setAmount(0d);
    }

    @Test
    void testSetStatus() {
        billDto.setStatus(EStatus.PROCESSED);
    }

    @Test
    void testSetStartDate() {
        billDto.setStartDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime());
    }

    @Test
    void testSetEndDate() {
        billDto.setEndDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime());
    }

    @Test
    void testSetTransactions() {
        billDto.setTransactions(new HashSet<TransactionDto>(Arrays.asList(new TransactionDto())));
    }

    @Test
    void testEquals() {
        boolean result = billDto.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = billDto.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = billDto.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = billDto.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme