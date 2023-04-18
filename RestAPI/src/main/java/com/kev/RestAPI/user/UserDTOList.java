package com.kev.RestAPI.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

public class UserDTOList {

    private List<UserDTO> list;

}
