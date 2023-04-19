package com.kev.RestAPI.simulation;


import com.kev.RestAPI.factory.DTOFactory;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/rest/simulation")
@AllArgsConstructor
@Validated
public class SimulationController {

    private final SimulationService simulationService;
    private final DTOFactory dtoFactory;

    @GetMapping(path = "/all")
    public SimulationDTOList getSimulationList() {
        SimulationDTOList simulationDTOList = new SimulationDTOList(simulationService.getSimulationList());
        return simulationDTOList;
    }

    @GetMapping(path = "/{id}")
    public SimulationDTO getSimulationById(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Id must be greater than 0") int simulationId) {
        return dtoFactory.createDTO(simulationService.getSimulationById(simulationId));
    }

    @PostMapping(path = "/run8")
    public SimulationDTO addSimulation8
            (@Valid @RequestBody SimulationInputDTO simulationInputDTO) throws Exception {
        return dtoFactory.createDTO(simulationService.addSimulation8(simulationInputDTO));
    }

    @PostMapping(path = "/run9")
    public SimulationDTO addSimulation9
            (@Valid @RequestBody SimulationInputDTO simulationInputDTO) throws Exception {
        return dtoFactory.createDTO(simulationService.addSimulation9(simulationInputDTO));
    }

    @PostMapping(path = "/update/{id}")
    public SimulationDTO updateSimulation(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Id must be greater than 0") int simulationId,
            @Valid @RequestBody SimulationInputDTO simulationInputDTO) throws Exception {
        return dtoFactory.updateDTO(simulationService.updateSimulation(simulationId, simulationInputDTO));
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteSimulation(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Id must be greater than 0") int simulationId) {
        return simulationService.deleteSimulation(simulationId);
    }


}
