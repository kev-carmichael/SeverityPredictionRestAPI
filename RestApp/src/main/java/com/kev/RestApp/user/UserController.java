package com.kev.RestApp.user;


import com.kev.RestApp.simulation.SimulationDTOList;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
