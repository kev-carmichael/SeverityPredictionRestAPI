package com.kev.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

//@AllArgsConstructor
//@RequiredArgsConstructor - NEED TO UNCOMMENT THIS WHEN ADD MORE THAN 2 FIELDS
@Getter
@Setter

public class UserDTOList {

    private List<UserDTO> list;

    @JsonCreator
    public UserDTOList(@JsonProperty("list") List<UserDTO> list){
        this.list = list;
    }



}
