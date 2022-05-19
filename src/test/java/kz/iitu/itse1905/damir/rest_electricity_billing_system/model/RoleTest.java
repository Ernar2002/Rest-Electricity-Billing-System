package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class RoleTest {
    @Mock
    Set<User> users;
    @Mock
    Date created;
    //Field active of type EActive - was not mocked since Mockito doesn't mock enums
    @InjectMocks
    Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetName() {
        role.setName("name");
    }

    @Test
    void testSetUsers() {
        role.setUsers(new HashSet<User>(Arrays.asList(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))));
    }

    @Test
    void testEquals() {
        boolean result = role.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = role.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = role.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = role.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        Role.RoleBuilder result = Role.builder();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSetId() {
        role.setId(Long.valueOf(1));
    }

    @Test
    void testSetCreated() {
        role.setCreated(new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime());
    }

    @Test
    void testSetActive() {
        role.setActive(EActive.ACTIVE);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme