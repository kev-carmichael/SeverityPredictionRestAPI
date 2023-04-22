package com.kev.RestAPI.simulation;

import com.kev.RestAPI.admin.AdminRepository;
import com.kev.RestAPI.entity.Admin;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SimulationControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SimulationService simulationService;

    @Autowired
    private DTOFactory dtoFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimulationRepository simulationRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void t15_when_GetSimulationWithInvalidSimulationId_expect_BadRequestAndCorrectErrorMessage() throws Exception {

        Admin admin = new Admin(
                0,
                "Zebedee@gmail.com",
                "password26",
                "abc123");

        simulationRepository.deleteAll();
        userRepository.deleteAll();
        adminRepository.deleteAll();

        adminRepository.save(admin);

        mockMvc
                .perform(get("/rest/simulation/0").header("AUTHORIZATION", "abc123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Validation error: Id must be greater than 0"));
    }

}