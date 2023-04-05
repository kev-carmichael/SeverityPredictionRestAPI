package com.kev.RestApp.factory;

import com.kev.RestApp.entity.User;
import com.kev.RestApp.user.UserDTO;
import com.kev.RestApp.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class DTOFactory {

    private final UserRepository userRepository;

    public DTOFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO createDTO(User user) {
        //Needs try and catch with return createDTOWithoutSimulation(user);
            UserDTO userDTO =
                    new UserDTO(
                            user.getUserId(),
                            user.getEmail());
            return userDTO;
    }

}
