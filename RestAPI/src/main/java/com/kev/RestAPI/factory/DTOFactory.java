package com.kev.RestAPI.factory;

import com.kev.RestAPI.admin.AdminDTO;
import com.kev.RestAPI.entity.Admin;
import com.kev.RestAPI.entity.Simulation;
import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.simulation.SimulationDTO;
import com.kev.RestAPI.user.NewUserAndCheckCredentialsDTO;
import com.kev.RestAPI.user.UserDTO;
import com.kev.RestAPI.user.UserRepository;
import com.kev.RestAPI.user.UserSafeOutputDTO;
import org.springframework.stereotype.Component;

@Component
public class DTOFactory {

    private final UserRepository userRepository;

    public DTOFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO createDTO(User user) {
        UserDTO userDTO =
                new UserDTO(
                        user.getUserId(),
                        user.getEmail(),
                        user.getToken()
                );
        return userDTO;
    }

    public UserSafeOutputDTO createSafeDTO(User user) {
        UserSafeOutputDTO userSafeOutputDTO =
                new UserSafeOutputDTO(
                        user.getUserId(),
                        user.getEmail()
                );
        return userSafeOutputDTO;
    }

    public SimulationDTO createDTO(Simulation simulation) {

        if (simulation == null)
        {
            return null;
        }

        SimulationDTO simulationDTO =
                new SimulationDTO(
                        simulation.getSimulationId(),
                        simulation.getLastInput(),
                        createSafeDTO(simulation.getUser()),
                        simulation.getAgeAircraft(),
                        simulation.getNoOfPassengers(),
                        simulation.getPicLicence(),
                        simulation.getPicAge(),
                        simulation.getTotalHrs(),
                        simulation.getTypeHrs(),
                        simulation.getNinetyDayHrs(),
                        simulation.getTwentyEightDayHrs(),
                        simulation.getDayOfWeek(),
                        simulation.getAccidentSeverity(),
                        simulation.getInjurySeverity());
        return simulationDTO;
    }

    public SimulationDTO updateDTO(Simulation simulation) {
        if (simulation == null) {
            return null;
        }

        SimulationDTO simulationDTO =
                new SimulationDTO(
                        simulation.getSimulationId(),
                        simulation.getLastInput(),
                        createSafeDTO(simulation.getUser()),
                        simulation.getAgeAircraft(),
                        simulation.getNoOfPassengers(),
                        simulation.getPicLicence(),
                        simulation.getPicAge(),
                        simulation.getTotalHrs(),
                        simulation.getTypeHrs(),
                        simulation.getNinetyDayHrs(),
                        simulation.getTwentyEightDayHrs(),
                        simulation.getDayOfWeek(),
                        simulation.getAccidentSeverity(),
                        simulation.getInjurySeverity());

        return simulationDTO;
    }

    public UserDTO createDTOWithToken(User user) {
        if (user == null)
        {
            return null;
        }

        UserDTO userDTO =
                new UserDTO(
                        user.getUserId(),
                        user.getEmail(),
                        user.getToken());

        return userDTO;
    }

    public AdminDTO createDTO(Admin admin)
    {
        if (admin == null)
        {
            return null;
        }

        AdminDTO adminDTO =
                new AdminDTO(
                        admin.getAdminId(),
                        admin.getEmail(),
                        admin.getToken());

        return adminDTO;
    }


}
