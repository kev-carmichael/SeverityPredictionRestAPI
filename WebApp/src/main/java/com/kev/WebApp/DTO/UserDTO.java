package com.kev.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@RequiredArgsConstructor - NEED TO UNCOMMENT THIS WHEN ADD MORE THAN 2 FIELDS
@Getter
@Setter


public class UserDTO {

    private final int userId;
    private final String email;

    @JsonCreator
    public UserDTO(@JsonProperty("userId") int userId,
                   @JsonProperty("email") String email){
        this.userId = userId;
        this.email = email;
    }



    @Override
    public String toString()
    {
        return String.format(
                "%s, %s",
                userId,
                email);
    }

}
