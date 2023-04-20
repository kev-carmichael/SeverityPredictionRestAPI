package com.kev.RestAPI.user;


import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.factory.DTOFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor


public class UserService {

    UserRepository userRepository;
    DTOFactory dtoFactory;

    public List<UserDTO> getUserList() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userRepository.findAll()){
            UserDTO userDTO = dtoFactory.createDTO(user);
            list.add(userDTO);
        }
        return list;
    }

    public User addUser(NewUserDTO newUserDTO) {

        if(findIfEmailExists(newUserDTO.getEmail())) {
            return null;
        }

//        String token =
//                stringHasher.hashString(
//                        newUserDTO.getEmail() + ":" + LocalDateTime.now());

        int userSize = userRepository.findAll().size();
        User user = new User(
                (userSize + 1),
                newUserDTO.getEmail(),
                newUserDTO.getPassword()
//                , token
        );
        return userRepository.save(user);
    }

    public boolean findIfEmailExists(String email) {
        for (User user : userRepository.findAll()){
            if(user.getEmail() == email) {
                return true;
            }
        }
        return false;
    }





}
