package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.user;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.BillDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.TransactionService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response.MessageResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;

class BillRestControllerTest {
    @Mock
    UserService userService;
    @Mock
    BillService billService;
    @Mock
    ComplaintService complaintService;
    @Mock
    TransactionService transactionService;
    @InjectMocks
    BillRestController billRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBills() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("USER");
        user.setRoles(roles);

        Set<Complaint> complaints = new HashSet<>();
        Complaint complaint = new Complaint();
        complaint.setText("Incorrect amount");
        user.setComplaints(complaints);
        complaint.setUser(user);

        Set<Bill> bills = new HashSet<>();
        Bill bill = new Bill();
        bill.setAmount(400);
        bill.setStartDate(new Date());
        bill.setEndDate(new Date());
        bill.setUnits(50);
        bill.setStatus(EStatus.PROCESSED);
        user.setBills(bills);
        bill.setUser(user);
        userService.save(user);
        billService.save(bill);
        complaintService.save(complaint);
        when(userService.findByEmail(user.getEmail())).thenReturn(user);
        when(billService.getBillsOfUser(user)).thenReturn((List<Bill>) bills);

        ResponseEntity<List<BillDto>> result = billRestController.getAllBills(null);
        Assertions.assertEquals(bills, result);
    }

    @Test
    void testPayForBill() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("USER");
        user.setRoles(roles);

        Set<Complaint> complaints = new HashSet<>();
        Complaint complaint = new Complaint();
        complaint.setText("Incorrect amount");
        user.setComplaints(complaints);
        complaint.setUser(user);

        Set<Bill> bills = new HashSet<>();
        Bill bill = new Bill();
        bill.setAmount(400);
        bill.setStartDate(new Date());
        bill.setEndDate(new Date());
        bill.setUnits(50);
        bill.setStatus(EStatus.PROCESSED);
        user.setBills(bills);
        bill.setUser(user);
        userService.save(user);
        billService.save(bill);
        complaintService.save(complaint);

        when(userService.findByEmail(user.getEmail())).thenReturn(user);
        when(userService.getById(user.getId())).thenReturn(user);
        when(billService.getById(bill.getId())).thenReturn(bill);

        ResponseEntity<?> result = billRestController.payForBill(bill.getId(), 400d, null);
        Assertions.assertEquals(new MessageResponse("Payed successfully"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme