package kz.iitu.itse1905.damir.rest_electricity_billing_system.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.AssertTrue;

public class UserEmailValidator implements
        ConstraintValidator<UserEmailContraint, String> {


    @Override
    @AssertTrue(message = "User should have unique email")
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }

    @Override
    public void initialize(UserEmailContraint userEmail) {
    }
}