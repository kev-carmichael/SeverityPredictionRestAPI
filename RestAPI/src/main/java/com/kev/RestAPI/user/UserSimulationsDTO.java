package com.kev.RestAPI.user;

import com.kev.RestAPI.simulation.SimulationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class UserSimulationsDTO {

    private List<SimulationDTO> list;

}
