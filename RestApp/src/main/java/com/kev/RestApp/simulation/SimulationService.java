package com.kev.RestApp.simulation;

import com.kev.RestApp.dto.Result;
import com.kev.RestApp.entity.Simulation;
import com.kev.RestApp.factory.DTOFactory;
import com.kev.RestApp.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimulationService {

    private DTOFactory dtoFactory;
    private final SimulationRepository simulationRepository;

    public List<SimulationDTO> getSimulationList(){
        List<SimulationDTO> list = new ArrayList<>();
        for (Simulation simulation : simulationRepository.findAll()){
            SimulationDTO simulationDTO = dtoFactory.createDTO(simulation);
            list.add(simulationDTO);
        }
        return list;
    }

    public Simulation addSimulation8(SimulationInputDTO simulationInputDTO) throws Exception{
        int size = simulationRepository.findAll().size();

        Loader loader = new Loader();

        Simulation simulation = new Simulation(
                size + 1,
                simulationInputDTO.getAgeAircraft(),
                simulationInputDTO.getNoOfPassengers(),
                simulationInputDTO.getPicLicence(),
                simulationInputDTO.getPicAge(),
                simulationInputDTO.getTotalHrs(),
                simulationInputDTO.getTypeHrs(),
                simulationInputDTO.getNinetyDayHrs(),
                simulationInputDTO.getTwentyEightDayHrs(),
                null,
                loader.load8(simulationInputDTO),
                null);
        return simulationRepository.save(simulation);
    }

    public Simulation addSimulation9(SimulationInputDTO simulationInputDTO) throws Exception{
        int size = simulationRepository.findAll().size();

        Loader loader = new Loader();

        Simulation simulation = new Simulation(
                size + 1,
                simulationInputDTO.getAgeAircraft(),
                simulationInputDTO.getNoOfPassengers(),
                simulationInputDTO.getPicLicence(),
                simulationInputDTO.getPicAge(),
                simulationInputDTO.getTotalHrs(),
                simulationInputDTO.getTypeHrs(),
                simulationInputDTO.getNinetyDayHrs(),
                simulationInputDTO.getTwentyEightDayHrs(),
                simulationInputDTO.getDayOfWeek(),
                null,
                loader.load9(simulationInputDTO));
        return simulationRepository.save(simulation);
    }


}
