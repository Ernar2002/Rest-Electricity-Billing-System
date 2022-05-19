package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class ComplaintTest {
    @Mock
    User user;
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Complaint complaint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetText() {
        complaint.setText("text");
    }

    @Test
    void testSetUser() {
        complaint.setUser(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 53).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 53).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 53).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
    }

    @Test
    void testEquals() {
        when(user.equals(any())).thenReturn(true);

        boolean result = complaint.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = complaint.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        when(user.hashCode()).thenReturn(0);

        int result = complaint.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = complaint.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Complaint.ComplaintBuilder result = Complaint.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        complaint.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        complaint.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 53).getTime());
    }

    @Test
    void testSetActive() {
        complaint.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme