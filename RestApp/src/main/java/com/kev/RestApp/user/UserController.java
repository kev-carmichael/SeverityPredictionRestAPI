package com.kev.RestApp.user;


import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Validated


public class UserController {

    private final UserService userService;

    @GetMapping(path = "/all")
    public List<UserDTO> getCustomerList() {
        return userService.getUserList();
    }


}
