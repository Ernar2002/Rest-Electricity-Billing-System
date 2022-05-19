package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class BillTest {
    //Field status of type EStatus - was not mocked since Mockito doesn't mock enums
    @Mock
    Date startDate;
    @Mock
    Date endDate;
    @Mock
    Set<Transaction> transactions;
    @Mock
    User user;
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Bill bill;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddTransactions() {
        bill.addTransactions(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))));
    }

    @Test
    void testSetUnits() {
        bill.setUnits(0);
    }

    @Test
    void testSetAmount() {
        bill.setAmount(0d);
    }

    @Test
    void testSetStatus() {
        bill.setStatus(EStatus.PROCESSED);
    }

    @Test
    void testSetStartDate() {
        bill.setStartDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime());
    }

    @Test
    void testSetEndDate() {
        bill.setEndDate(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime());
    }

    @Test
    void testSetTransactions() {
        bill.setTransactions(new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))))));
    }

    @Test
    void testSetUser() {
        bill.setUser(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
    }

    @Test
    void testEquals() {
        when(user.equals(any())).thenReturn(true);

        boolean result = bill.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = bill.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        when(user.hashCode()).thenReturn(0);

        int result = bill.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = bill.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Bill.BillBuilder result = Bill.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        bill.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        bill.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 52).getTime());
    }

    @Test
    void testSetActive() {
        bill.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme