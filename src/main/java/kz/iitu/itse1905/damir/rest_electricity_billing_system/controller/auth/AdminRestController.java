package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.auth;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.BillDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.ComplaintDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.UserDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {

    private final UserService userService;
    private final ComplaintService complaintService;
    private final BillService billService;

    @Autowired
    public AdminRestController(
            UserService userService,
            ComplaintService complaintService,
            BillService billService
    ){
        this.userService = userService;
        this.complaintService = complaintService;
        this.billService = billService;
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email){

        if(email == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByEmail(email);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(UserDto.fromUser(user), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/complaints")
    public ResponseEntity<List<ComplaintDto>> getComplaintsOfUser(@PathVariable("userId") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Complaint> complaints = complaintService.getComplaintsOfUser(user);

        List<ComplaintDto> complaintDtos = new ArrayList<>();

        for(Complaint complaint: complaints){
            complaintDtos.add(ComplaintDto.fromComplaint(complaint));
        }

        return new ResponseEntity<>(complaintDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/bills")
    public ResponseEntity<List<BillDto>> getBillsOfUser(@PathVariable("userId") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Bill> bills = billService.getBillsOfUser(user);

        List<BillDto> billDtos = new ArrayList<>();

        for(Bill bill: bills){
            billDtos.add(BillDto.fromBill(bill));
        }

        return new ResponseEntity<>(billDtos, HttpStatus.OK);
    }
}
