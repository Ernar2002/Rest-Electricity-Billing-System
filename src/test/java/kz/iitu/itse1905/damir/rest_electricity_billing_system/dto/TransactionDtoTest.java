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

class TransactionDtoTest {
    @Mock
    Date pDate;
    //Field status of type EStatus - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    TransactionDto transactionDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFromTransaction() {
        TransactionDto result = TransactionDto.fromTransaction(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))));
        Assertions.assertEquals(new TransactionDto(), result);
    }

    @Test
    void testSetId() {
        transactionDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetPayable() {
        transactionDto.setPayable(0d);
    }

    @Test
    void testSetPDate() {
        transactionDto.setPDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime());
    }

    @Test
    void testSetStatus() {
        transactionDto.setStatus(EStatus.PROCESSED);
    }

    @Test
    void testEquals() {
        boolean result = transactionDto.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = transactionDto.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = transactionDto.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = transactionDto.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme