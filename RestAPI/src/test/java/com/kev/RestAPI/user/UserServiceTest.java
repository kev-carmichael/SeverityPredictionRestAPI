package com.kev.RestAPI.user;

import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.util.StringHasher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    @Test
    void t8_when_AddUserAndEmailAlreadyExists_Expect_NullResult() {

        UserRepository mockUserRepository = mock(UserRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        StringHasher mockStringHasher = mock(StringHasher.class);

        UserService userService = new UserService(mockUserRepository,
                mockDTOFactory, mockStringHasher);

        NewUserAndCheckCredentialsDTO newUserAndCheckCredentialsDTO =
                new NewUserAndCheckCredentialsDTO("Eric@gmail.com", "password5");

        assertNull(userService.addUser(new NewUserAndCheckCredentialsDTO("Eric@gmail.com", "password5")));

    }

}