package kz.iitu.itse1905.damir.rest_electricity_billing_system.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class JwtUserTest {
    @Mock
    Set<Role> roles;
    @InjectMocks
    JwtUser jwtUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetId() {
        jwtUser.setId(Long.valueOf(1));
    }

    @Test
    void testSetEmail() {
        jwtUser.setEmail("email");
    }

    @Test
    void testSetFirstName() {
        jwtUser.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        jwtUser.setLastName("lastName");
    }

    @Test
    void testSetPassword() {
        jwtUser.setPassword("password");
    }

    @Test
    void testSetPhoneNumber() {
        jwtUser.setPhoneNumber("phoneNumber");
    }

    @Test
    void testSetIin() {
        jwtUser.setIin("iin");
    }

    @Test
    void testSetAddress() {
        jwtUser.setAddress("address");
    }

    @Test
    void testSetRoles() {
        jwtUser.setRoles(new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(null)), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 54).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))))))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme