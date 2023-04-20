package com.kev.RestAPI.admin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;


@RequiredArgsConstructor
@Getter
public class AdminCheckCredentialsDTO {

    @Email(message = "Email is not in the correct format")
    private final String email;

    private final String password;

}
