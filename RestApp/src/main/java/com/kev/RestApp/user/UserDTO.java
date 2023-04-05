package com.kev.RestApp.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
//@RequiredArgsConstructor - NEED TO UNCOMMENT THIS WHEN ADD MORE THAN 2 FIELDS
@Getter
@Setter


public class UserDTO {

    private final int userId;
    private final String email;
}
