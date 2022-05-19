package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.admin;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.BillDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.ComplaintDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.UserDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.*;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.BillRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;

class AdminRestControllerTest {
    @Mock
    UserService userService;
    @Mock
    ComplaintService complaintService;
    @Mock
    BillService billService;
    @InjectMocks
    AdminRestController adminRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUserByEmail() {
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

        when(userService.findByEmail(user.getEmail())).thenReturn(user);

        ResponseEntity<UserDto> result = adminRestController.getUserByEmail("email");
        Assertions.assertEquals(UserDto.fromUser(user), result.getBody());
    }

    @Test
    void testGetComplaintsOfUser() {
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
        when(userService.getById(user.getId())).thenReturn(user);
        when(complaintService.getById(complaint.getId())).thenReturn(complaint);
        when(complaintService.getComplaintsOfUser(user)).thenReturn((List<Complaint>) complaints);
        when(billService.getById(bill.getId())).thenReturn(bill);

        ResponseEntity<List<ComplaintDto>> result = adminRestController.getComplaintsOfUser(user.getId());
        Assertions.assertEquals(complaints, result);
    }

    @Test
    void testGetBillsOfUser() {
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

        when(userService.getById(user.getId())).thenReturn(user);
        when(complaintService.getById(complaint.getId())).thenReturn(complaint);
        when(billService.getBillsOfUser(user)).thenReturn((List<Bill>) bills);
        when(billService.getById(bill.getId())).thenReturn(bill);

        ResponseEntity<List<BillDto>> result = adminRestController.getBillsOfUser(user.getId());
        Assertions.assertEquals(bills, result);
    }

    @Test
    void testAddBillToUser() {
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

        when(userService.getById(user.getId())).thenReturn(user);
        when(complaintService.getById(complaint.getId())).thenReturn(complaint);
        when(billService.getById(bill.getId())).thenReturn(bill);

        ResponseEntity<?> result = adminRestController.addBillToUser(user.getId(), new BillRequest(0, ETariff.TWOHUNDRED, new GregorianCalendar(2022, Calendar.MAY, 17, 1, 22).getTime(), new GregorianCalendar(2022, Calendar.MAY, 17, 1, 22).getTime()));
        Assertions.assertEquals(bill, result);
    }

    @Test
    void testDeleteBillFromUser() {
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

        when(userService.getById(user.getId())).thenReturn(user);
        when(complaintService.getById(complaint.getId())).thenReturn(complaint);
        when(billService.getById(bill.getId())).thenReturn(bill);

        ResponseEntity<?> result = adminRestController.deleteBillFromUser(user.getId(), bill.getId());
        Assertions.assertEquals(bill, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme