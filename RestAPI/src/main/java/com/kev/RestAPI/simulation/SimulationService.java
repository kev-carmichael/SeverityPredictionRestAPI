package com.kev.RestAPI.simulation;

import com.kev.RestAPI.entity.Simulation;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
@AllArgsConstructor
public class SimulationService {

    private DTOFactory dtoFactory;
    private final SimulationRepository simulationRepository;

    public List<SimulationDTO> getSimulationList() {
        List<SimulationDTO> list = new ArrayList<>();
        for (Simulation simulation : simulationRepository.findAll()) {
            SimulationDTO simulationDTO = dtoFactory.createDTO(simulation);
            list.add(simulationDTO);
        }
        return list;
    }

    public Simulation getSimulationById(int simulationId) {
        return simulationRepository.findById(simulationId).orElse(null);
    }

    public Simulation addSimulation8(SimulationInputDTO simulationInputDTO) throws Exception {
        int size = simulationRepository.findAll().size();

        Loader loader = new Loader();

        Simulation simulation = new Simulation(
                size + 1,
                simulationInputDTO.getLastInput(),
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

    public Simulation addSimulation9(SimulationInputDTO simulationInputDTO) throws Exception {
        int size = simulationRepository.findAll().size();

        Loader loader = new Loader();

        Simulation simulation = new Simulation(
                size + 1,
                simulationInputDTO.getLastInput(),
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

    public Simulation updateSimulation9(int simulationId, SimulationInputDTO simulationInputDTO) throws Exception {
        Optional<Simulation> originalSimulation = simulationRepository.findById(simulationId);

        if (!originalSimulation.isPresent()) {
            return null;
        }

        Simulation simulationEntity = originalSimulation.get();
        Loader loader = new Loader();

        //INPUT UPDATE CHANGES INTO ENTITY
        simulationEntity.setLastInput(LocalDateTime.now().toString());
        simulationEntity.setAgeAircraft(simulationInputDTO.getAgeAircraft());
        simulationEntity.setNoOfPassengers(simulationInputDTO.getNoOfPassengers());
        simulationEntity.setPicLicence(simulationInputDTO.getPicLicence());
        simulationEntity.setPicAge(simulationInputDTO.getPicAge());
        simulationEntity.setTotalHrs(simulationInputDTO.getTotalHrs());
        simulationEntity.setTypeHrs(simulationInputDTO.getTypeHrs());
        simulationEntity.setNinetyDayHrs(simulationInputDTO.getNinetyDayHrs());
        simulationEntity.setTwentyEightDayHrs(simulationInputDTO.getTwentyEightDayHrs());
        simulationEntity.setDayOfWeek(simulationInputDTO.getDayOfWeek());

        //INPUT SEVERITY RESULT FOR UPDATED VARS
        simulationEntity.setInjurySeverity(loader.load9(simulationInputDTO));

        return simulationRepository.save(simulationEntity);
    }

    public boolean deleteSimulation(int simulationId)
    {
        if (simulationRepository.existsById(simulationId))
        {
            try
            {
                simulationRepository.deleteById(simulationId);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
                return false;
            }
        }
        return false;
    }


}
