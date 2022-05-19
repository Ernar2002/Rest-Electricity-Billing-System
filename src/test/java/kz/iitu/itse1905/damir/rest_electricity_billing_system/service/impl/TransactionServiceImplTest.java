package kz.iitu.itse1905.damir.rest_electricity_billing_system.service.impl;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.BillRepository;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.*;

import static org.mockito.Mockito.*;

class TransactionServiceImplTest {
    @Mock
    BillRepository billRepository;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    Logger log;
    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        transactionServiceImpl.save(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))));
    }

    @Test
    void testUpdate() {
        transactionServiceImpl.update(Long.valueOf(1), new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))));
    }

    @Test
    void testGetById() {
        Transaction result = transactionServiceImpl.getById(Long.valueOf(1));
        Assertions.assertEquals(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null)))))), result);
    }

    @Test
    void testDelete() {
        transactionServiceImpl.delete(Long.valueOf(1));
    }

    @Test
    void testGetAll() {
        List<Transaction> result = transactionServiceImpl.getAll();
        Assertions.assertEquals(Arrays.<Transaction>asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(null)), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))))), result);
    }

    @Test
    void testAddToBill() {
        transactionServiceImpl.addToBill(0d, new Bill(0, 0d, EStatus.PROCESSED, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), new HashSet<Transaction>(Arrays.asList(new Transaction(0d, new GregorianCalendar(2022, Calendar.MAY, 19, 19, 57).getTime(), EStatus.PROCESSED, null))), new User("email", "password", "firstName", "lastName", "phoneNumber", "iin", "address", new HashSet<Role>(Arrays.asList(new Role("name", new HashSet<User>(Arrays.asList(null))))), new HashSet<Bill>(Arrays.asList(null)), new HashSet<Complaint>(Arrays.asList(new Complaint("text", null))))));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme