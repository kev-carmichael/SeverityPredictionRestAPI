package com.kev.RestApp.user;


import com.kev.RestApp.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor


public class UserService {

    public List<UserDTO> getUserList() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userRepository.findAll()){
            UserDTO userDTO = dtoFactory.createDTO(user);
            list.add(userDTO);
        }
        return list;
    }



}
