package com.kev.RestAPI.user;


import com.kev.RestAPI.factory.DTOFactory;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/rest/user")
@AllArgsConstructor
@Validated


public class UserController {

    private final UserService userService;
    private final DTOFactory dtoFactory;

    @GetMapping(path = "/all")
    public UserDTOList getUserList() {
        UserDTOList userDTOList = new UserDTOList(userService.getUserList());
        return userDTOList;
    }

    @PostMapping(path = "/add")
    public UserDTO addUser(@RequestBody NewUserAndCheckCredentialsDTO newUserAndCheckCredentialsDTO)
    {
        return dtoFactory.createDTO(userService.addUser(newUserAndCheckCredentialsDTO));
    }

    @PostMapping(path = "/login")
    public UserDTO checkCredentials(@Valid @RequestBody NewUserAndCheckCredentialsDTO credsDTO)
    {
        return dtoFactory.createDTOWithToken(userService.checkCredentials(credsDTO));
    }

    @PostMapping(path = "/logout/{id}")
    public void logout(
            @PathVariable(name = "id")
            @Min(value = 1, message = "customerId must be greater than 0") int id) {
        userService.clearToken(id);
    }






}
