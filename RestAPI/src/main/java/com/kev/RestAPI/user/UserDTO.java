package com.kev.RestAPI.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@AllArgsConstructor
//@RequiredArgsConstructor - NEED TO UNCOMMENT THIS IF ADD MORE THAN 2 FIELDS
@Getter
@Setter


public class UserDTO {

    @Min(value = 1, message = "Id must be greater than 0")
    private final int userId;

    @Email(message = "Email is not in the correct format")
    private final String email;
}
