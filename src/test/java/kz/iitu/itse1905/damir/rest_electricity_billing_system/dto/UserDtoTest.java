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

class UserDtoTest {
    @Mock
    Set<BillDto> bills;
    @Mock
    Set<ComplaintDto> complaints;
    @Mock
    Set<RoleDto> roles;
    @InjectMocks
    UserDto userDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFromUser() {
        UserDto result = UserDto.fromUser(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 50).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
        Assertions.assertEquals(new UserDto(), result);
    }

    @Test
    void testSetId() {
        userDto.setId(Long.valueOf(1));
    }

    @Test
    void testSetEmail() {
        userDto.setEmail("email");
    }

    @Test
    void testSetFirstName() {
        userDto.setFirstName("firstName");
    }

    @Test
    void testSetLastName() {
        userDto.setLastName("lastName");
    }

    @Test
    void testSetPhoneNumber() {
        userDto.setPhoneNumber("phoneNumber");
    }

    @Test
    void testSetIin() {
        userDto.setIin("iin");
    }

    @Test
    void testSetAddress() {
        userDto.setAddress("address");
    }

    @Test
    void testSetBills() {
        userDto.setBills(new HashSet<BillDto>(Arrays.asList(new BillDto())));
    }

    @Test
    void testSetComplaints() {
        userDto.setComplaints(new HashSet<ComplaintDto>(Arrays.asList(new ComplaintDto())));
    }

    @Test
    void testSetRoles() {
        userDto.setRoles(new HashSet<RoleDto>(Arrays.asList(new RoleDto())));
    }

    @Test
    void testEquals() {
        boolean result = userDto.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = userDto.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = userDto.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = userDto.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme