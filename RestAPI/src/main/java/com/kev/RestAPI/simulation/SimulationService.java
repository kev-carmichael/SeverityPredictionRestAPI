package com.kev.RestAPI.simulation;

import com.kev.RestAPI.entity.Simulation;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Simulation updateSimulation(int simulationId, String picLicence) {
        Optional<Simulation> originalSimulation = simulationRepository.findById(simulationId);

        if (!originalSimulation.isPresent()) {
            return null;
        }

        Simulation simulationEntity = originalSimulation.get();
        simulationEntity.setPicLicence(picLicence);
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
