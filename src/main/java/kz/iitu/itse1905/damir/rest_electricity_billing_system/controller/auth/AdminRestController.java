package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.auth;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.UserDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get-user")
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
}
