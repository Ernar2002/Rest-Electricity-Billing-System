package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.details;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import lombok.Data;

@Data
public class UserDetails {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String iin;
    private String address;

    public static UserDetails fromUser(User user){
        UserDetails userDetails = new UserDetails();

        userDetails.setEmail(user.getEmail());
        userDetails.setFirstName(user.getFirstName());
        userDetails.setLastName(user.getLastName());
        userDetails.setPhoneNumber(user.getPhoneNumber());
        userDetails.setIin(user.getIin());
        userDetails.setAddress(user.getAddress());

        return userDetails;
    }
}
