package com.kev.RestApp.simulation;


import com.kev.RestApp.dto.Result;
import com.kev.RestApp.factory.DTOFactory;
import com.kev.RestApp.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/simulation")
@AllArgsConstructor
public class SimulationController {

    private final SimulationService simulationService;
    private final DTOFactory dtoFactory;

    @GetMapping(path="/all")
    public SimulationDTOList getSimulationList(){
            SimulationDTOList simulationDTOList = new SimulationDTOList(simulationService.getSimulationList());
        return simulationDTOList;
    }

    @PostMapping(path = "/run8")
    public SimulationDTO addSimulation8
            (@RequestBody SimulationInputDTO simulationInputDTO) throws Exception {
        return dtoFactory.createDTO(simulationService.addSimulation8(simulationInputDTO));
    }

    @PostMapping(path = "/run9")
    public SimulationDTO addSimulation9
            (@RequestBody SimulationInputDTO simulationInputDTO) throws Exception {
        return dtoFactory.createDTO(simulationService.addSimulation9(simulationInputDTO));
    }

    @PostMapping(path = "/update/{id}")
    public SimulationDTO updateSimulation(
            @PathVariable(name = "id") int simulationId, @RequestBody String picLicence) {
        return dtoFactory.updateDTO(simulationService.updateSimulation(simulationId, picLicence));
    }





}
