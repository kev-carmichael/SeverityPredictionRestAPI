package com.kev.RestAPI.simulation;


import com.kev.RestAPI.factory.DTOFactory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="/{id}")
    public SimulationDTO getSimulationById(@PathVariable(name = "id") int simulationId){
        return dtoFactory.createDTO(simulationService.getSimulationById(simulationId));
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
            @PathVariable(name = "id") int simulationId, @RequestBody String picLicence) throws Exception {
        return dtoFactory.updateDTO(simulationService.updateSimulation9(simulationId, picLicence));
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteSimulation(@PathVariable(name = "id") int simulationId)
    {
        return simulationService.deleteSimulation(simulationId);
    }






}
