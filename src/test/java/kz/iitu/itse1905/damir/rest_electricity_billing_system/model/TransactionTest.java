package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class TransactionTest {
    @Mock
    Date pDate;
    //Field status of type EStatus - was not mocked since Mockito doesn't mock enums
    @Mock
    Bill bill;
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetPayable() {
        transaction.setPayable(0d);
    }

    @Test
    void testSetPDate() {
        transaction.setPDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime());
    }

    @Test
    void testSetStatus() {
        transaction.setStatus(EStatus.PROCESSED);
    }

    @Test
    void testSetBill() {
        transaction.setBill(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))));
    }

    @Test
    void testEquals() {
        when(bill.equals(any())).thenReturn(true);

        boolean result = transaction.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = transaction.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        when(bill.hashCode()).thenReturn(0);

        int result = transaction.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = transaction.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Transaction.TransactionBuilder result = Transaction.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        transaction.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        transaction.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime());
    }

    @Test
    void testSetActive() {
        transaction.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme