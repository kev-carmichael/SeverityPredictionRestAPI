package com.kev.RestAPI.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
//@RequiredArgsConstructor - NEED TO UNCOMMENT THIS IF ADD MORE THAN 2 FIELDS
@Getter
@Setter


public class UserDTO {

    private final int userId;
    private final String email;
}
