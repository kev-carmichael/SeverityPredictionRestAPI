package com.kev.RestAPI.user;


import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.util.StringHasher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor


public class UserService {

    private final UserRepository userRepository;
    DTOFactory dtoFactory;
    private final StringHasher stringHasher;

    public List<UserDTO> getUserList() {
        List<UserDTO> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            UserDTO userDTO = dtoFactory.createDTO(user);
            list.add(userDTO);
        }
        return list;
    }

    public User addUser(NewUserAndCheckCredentialsDTO newUserAndCheckCredentialsDTO) {

        if (findIfEmailExists(newUserAndCheckCredentialsDTO.getEmail())) {
            return null;
        }

        String token =
                stringHasher.hashString(
                        newUserAndCheckCredentialsDTO.getEmail() + ":" + LocalDateTime.now());

        int userSize = userRepository.findAll().size();
        User user = new User(
                (userSize + 1),
                newUserAndCheckCredentialsDTO.getEmail(),
                newUserAndCheckCredentialsDTO.getPassword(),
                token,
                null
        );
        return userRepository.save(user);
    }

    public UserSimulationsDTO getUserSimulationsList(int userId) {
        for (User user : userRepository.findAll()){
            if(user.getUserId() == userId){
                UserSimulationsDTO userSimulationsDTO =
                        dtoFactory.createUserSimulationsDTO(user);
                return userSimulationsDTO;
            }
        }
        return null;
    }

    public boolean findIfEmailExists(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail() == email) {
                return true;
            }
        }
        return false;
    }

    public User checkCredentials(NewUserAndCheckCredentialsDTO credsDTO) {
        User user = userRepository.findByEmail(credsDTO.getEmail());
        if (user != null && user.getPassword().equals(credsDTO.getPassword())) {
            String token = stringHasher.hashString
                    (user.getEmail() + ":" + LocalDateTime.now());
            user.setToken(token);
            user = userRepository.save(user);
            return user;
        }
        return null;
    }

    public void clearToken(int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null && user.getToken() != null) {
            user.setToken(null);
            userRepository.save(user);
        }
    }


}
