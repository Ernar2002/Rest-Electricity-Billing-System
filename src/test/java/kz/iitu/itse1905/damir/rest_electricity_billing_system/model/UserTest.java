package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class UserTest {
    @Mock
    Set<Role> roles;
    @Mock
    Set<Bill> bills;
    @Mock
    Set<Complaint> complaints;
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddBill() {
        user.addBill(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))));
    }

    @Test
    void testDeleteBill() {
        user.deleteBill(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))));
    }

    @Test
    void testAddComplaint() {
        user.addComplaint(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))));
    }

    @Test
    void testRemoveComplaint() {
        user.removeComplaint(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))));
    }

    @Test
    void testSetEmail() {
        user.setEmail("email");
    }

    @Test
    void testSetPassword() {
        user.setPassword("password");
    }

    @Test
    void testSetFirstName() {
        user.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        user.setLastName("lastName");
    }

    @Test
    void testSetPhoneNumber() {
        user.setPhoneNumber("phoneNumber");
    }

    @Test
    void testSetIin() {
        user.setIin("iin");
    }

    @Test
    void testSetAddress() {
        user.setAddress("address");
    }

    @Test
    void testSetRoles() {
        user.setRoles(new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(null)), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))))))));
    }

    @Test
    void testSetBills() {
        user.setBills(new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))))));
    }

    @Test
    void testSetComplaints() {
        user.setComplaints(new HashSet<Complaint>(Arrays.asList(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))))));
    }

    @Test
    void testEquals() {
        boolean result = user.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = user.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = user.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = user.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        User.UserBuilder result = User.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        user.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        user.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime());
    }

    @Test
    void testSetActive() {
        user.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme