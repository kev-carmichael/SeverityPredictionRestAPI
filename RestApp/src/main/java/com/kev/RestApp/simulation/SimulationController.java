package com.kev.RestApp.simulation;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/simulation")
@AllArgsConstructor
public class SimulationController {

    private final SimulationService simulationService;

    @GetMapping(path="/all")
    public List<SimulationDTO> getSimulationList(){
        return simulationService.getSimulationList();
    }

}
