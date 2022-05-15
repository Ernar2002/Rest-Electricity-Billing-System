package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.user;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.BillDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.ComplaintDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.ComplaintService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.TransactionService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.ComplaintRequest;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/complaint/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintRestController {

    private final UserService userService;
    private final ComplaintService complaintService;

    @Autowired
    public ComplaintRestController(
            UserService userService,
            ComplaintService complaintService
    ){
        this.userService = userService;
        this.complaintService = complaintService;
    }

    @GetMapping
    public ResponseEntity<List<ComplaintDto>> getAllComplaints(Principal principal){
        if(principal == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByEmail(principal.getName());

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

    @PutMapping("/give-complaint")
    public ResponseEntity<?> giveComplaint(@RequestBody ComplaintRequest request, Principal principal){
        if(principal == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByEmail(principal.getName());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        complaintService.addComplaintToUser(request, user);

        return new ResponseEntity(new MessageResponse("Complain added successfully"), HttpStatus.OK);
    }

}
