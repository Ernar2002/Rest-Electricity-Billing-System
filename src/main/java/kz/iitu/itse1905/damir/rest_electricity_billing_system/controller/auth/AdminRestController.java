package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.auth;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.ComplaintDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.UserDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
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

    @Autowired
    public AdminRestController(
            UserService userService,
            ComplaintService complaintService
    ){
        this.userService = userService;
        this.complaintService = complaintService;
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
}
