package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Role;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String iin;
    private String address;
    private Set<Bill> bills;
    private Set<Complaint> complaints;
    private Set<Role> roles;

    public static UserDto fromUser(User user){
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setIin(user.getIin());
        userDto.setAddress(user.getAddress());
        userDto.setBills(user.getBills());
        userDto.setComplaints(user.getComplaints());
        userDto.setRoles(user.getRoles());

        return userDto;
    }
}
