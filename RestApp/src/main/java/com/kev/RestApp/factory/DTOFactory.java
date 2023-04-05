package com.kev.RestApp.factory;

import com.kev.RestApp.entity.User;
import com.kev.RestApp.user.UserDTO;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class DTOFactory {

    public UserDTO createDTO(User user) {
        //Needs try and catch with return createDTOWithoutSimulationy(user);
            UserDTO userDTO =
                    new UserDTO(
                            user.getUserId(),
                            user.getEmail());
            return userDTO;
    }

}
