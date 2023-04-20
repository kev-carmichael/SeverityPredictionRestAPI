package com.kev.RestAPI.user;


import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
@AllArgsConstructor
@Validated


public class UserController {

    private final UserService userService;

    @GetMapping(path = "/all")
    public UserDTOList getUserList() {
        UserDTOList userDTOList = new UserDTOList(userService.getUserList());
        return userDTOList;
    }





}
