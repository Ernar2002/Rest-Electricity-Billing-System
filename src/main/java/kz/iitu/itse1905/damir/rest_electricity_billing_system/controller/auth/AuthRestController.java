package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.auth;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.security.jwt.JwtUtil;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.SigninRequest;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request.SignupRequest;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/auth/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthRestController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @Autowired
    public AuthRestController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService studentService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = studentService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest requestDto){

        Optional<User> findUser = Optional.ofNullable(userService.findByEmail(requestDto.getEmail()));

        if(findUser.isPresent()){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: user exists"));
        }

        if(requestDto.getEmail() == null || requestDto.getPassword() == null || requestDto.getFirstName() == null || requestDto.getLastName() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Fill all data"));
        }

        User newUser = new User();
        newUser.setEmail(requestDto.getEmail());
        newUser.setPassword(requestDto.getPassword());
        newUser.setFirstName(requestDto.getFirstName());
        newUser.setLastName(requestDto.getLastName());
        newUser.setPhoneNumber(requestDto.getPhoneNumber());
        newUser.setAddress(requestDto.getAddress());
        newUser.setIin(requestDto.getIin());

        userService.save(newUser);
        return ResponseEntity.ok(new MessageResponse("User created"));
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody SigninRequest request) {
        try {
            String email = request.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, request.getPassword()));
            User user = userService.findByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }

            String token = jwtUtil.createToken(user.getEmail());

            Map<Object, Object> response = new HashMap<>();
            response.put("email", email);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Email or password is incorrect.");
        }
    }

}
