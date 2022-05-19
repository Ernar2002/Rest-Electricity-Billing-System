package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.ComplaintRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.UserRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.ComplaintRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

class ComplaintServiceImplTest {
    @Mock
    ComplaintRepository complaintRepository;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    ComplaintServiceImpl complaintServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        complaintServiceImpl.save(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))));
    }

    @Test
    void testUpdate() {
        complaintServiceImpl.update(Long.valueOf(1), new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))));
    }

    @Test
    void testGetById() {
        Complaint result = complaintServiceImpl.getById(Long.valueOf(1));
        Assertions.assertEquals(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null)))), result);
    }

    @Test
    void testDelete() {
        complaintServiceImpl.delete(Long.valueOf(1));
    }

    @Test
    void testGetAll() {
        List<Complaint> result = complaintServiceImpl.getAll();
        Assertions.assertEquals(Arrays.<Complaint>asList(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null))))), result);
    }

    @Test
    void testGetComplaintsOfUser() {
        when(complaintRepository.getComplaintsByUser(any())).thenReturn(Arrays.<Complaint>asList(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null))))));

        List<Complaint> result = complaintServiceImpl.getComplaintsOfUser(new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
        Assertions.assertEquals(Arrays.<Complaint>asList(new Complaint("text", new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(null))))), result);
    }

    @Test
    void testAddComplaintToUser() {
        complaintServiceImpl.addComplaintToUser(new ComplaintRequest("text"), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
    }

    @Test
    void testRemoveComplaintFromUser() {
        complaintServiceImpl.removeComplaintFromUser(Long.valueOf(1), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), null))), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme