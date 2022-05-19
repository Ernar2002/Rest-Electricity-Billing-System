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

class ComplaintDtoTest {
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @Mock
    Date created;
    @InjectMocks
    ComplaintDto complaintDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFromComplaint() {
        ComplaintDto result = ComplaintDto.fromComplaint(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))));
        Assertions.assertEquals(new ComplaintDto(), result);
    }

    @Test
    void testSetId() {
        complaintDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetText() {
        complaintDto.setText("text");
    }

    @Test
    void testSetActive() {
        complaintDto.setActive(EActive.ACTIVE);
    }

    @Test
    void testSetCreated() {
        complaintDto.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 49).getTime());
    }

    @Test
    void testEquals() {
        boolean result = complaintDto.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = complaintDto.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = complaintDto.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = complaintDto.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme