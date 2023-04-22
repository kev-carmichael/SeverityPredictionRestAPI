package com.kev.RestAPI.user;

import com.kev.RestAPI.admin.AdminRepository;
import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.simulation.SimulationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private DTOFactory dtoFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimulationRepository simulationRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void t10_when_UserExistsAndCheckCredentialsWithIncorrectPassword_Expect_NoUserReturned() throws Exception
    {
        User user = new User(
                0,
                "Zebedee@gmail.com",
                "password26",
                null,
                null);

        simulationRepository.deleteAll();
        userRepository.deleteAll();
        adminRepository.deleteAll();

        userRepository.save(user);

        String jsonCredentialsToCheck =
                "{\"email\": \"Zebedee@gmail.com\"," +
                        "\"password\": \"wrongPassword\"}";

        mockMvc
                .perform(post("/rest/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCredentialsToCheck))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void t11_when_UserExistsAndCheckCredentialsWithIncorrectEmail_Expect_NoUserReturned() throws Exception
    {
        User user = new User(
                0,
                "Zebedee@gmail.com",
                "password26",
                null,
                null);

        simulationRepository.deleteAll();
        userRepository.deleteAll();
        adminRepository.deleteAll();

        userRepository.save(user);

        String jsonCredentialsToCheck =
                "{\"email\": \"wrongEmail@gmail.com\"," +
                        "\"password\": \"password26\"}";

        mockMvc
                .perform(post("/rest/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCredentialsToCheck))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }



}