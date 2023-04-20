package com.kev.RestAPI.user;


import com.kev.RestAPI.factory.DTOFactory;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public UserDTO addUser(@RequestBody NewUserDTO newUserDTO)
    {
        return dtoFactory.createDTO(userService.addUser(newUserDTO));
    }




}
