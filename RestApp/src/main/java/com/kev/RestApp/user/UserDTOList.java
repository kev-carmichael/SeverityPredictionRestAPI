package com.kev.RestApp.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

public class UserDTOList {

    private List<UserDTO> list;

}
