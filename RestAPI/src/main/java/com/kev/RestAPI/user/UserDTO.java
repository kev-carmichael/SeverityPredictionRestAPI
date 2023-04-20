package com.kev.RestAPI.user;

import com.kev.RestAPI.simulation.SimulationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor //- NEED TO UNCOMMENT THIS IF ADD MORE THAN 2 FIELDS
@Getter
@Setter


public class UserDTO {

    @Min(value = 1, message = "Id must be greater than 0")
    private final int userId;

    @Email(message = "Email is not in the correct format")
    private final String email;

    @NotBlank(message = "Token cannot be blank")
    private final String token;

    @Min(value = 0, message = "numberOfSimulations must be equal to or greater than 0")
    private int numberOfSimulations;

    private List<SimulationDTO> simulations;




}
