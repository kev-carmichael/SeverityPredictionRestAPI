package com.kev.RestAPI.admin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;


@RequiredArgsConstructor
@Getter
public class AdminDTO {

    @Min(value = 1, message = "Id must be greater than 0")
    private final int id;

    @Email(message = "Email is not in the correct format")
    private final String email;

    @NotBlank(message = "Token cannot be blank")
    private final String token;

}
