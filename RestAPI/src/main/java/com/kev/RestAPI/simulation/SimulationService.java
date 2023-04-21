package com.kev.RestAPI.simulation;

import com.kev.RestAPI.entity.Simulation;
import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.exception.LastInputDateIsAfterDateTodayException;
import com.kev.RestAPI.exception.TwentyEightDayHrsGreaterThan90DayHrsException;
import com.kev.RestAPI.exception.TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.user.UserRepository;
import com.kev.RestAPI.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
@AllArgsConstructor
public class SimulationService {

    private DTOFactory dtoFactory;
    private final SimulationRepository simulationRepository;

    private final UserRepository userRepository;

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
        Optional<User> user = userRepository.
                findById(simulationInputDTO.getUser().getUserId());

        int size = simulationRepository.findAll().size();

        //check date of last input is not after today's date
        LocalDate now = LocalDate.now();
        if(simulationInputDTO.getLastInput().isAfter(now)){
            throw new LastInputDateIsAfterDateTodayException();
        }

        //check that type, 90-day and 28-day hrs are not more than total hrs
        if((simulationInputDTO.getTypeHrs()>simulationInputDTO.getTotalHrs() || simulationInputDTO.getNinetyDayHrs()>simulationInputDTO.getTotalHrs()) ||
                        simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getTotalHrs() ){
                    throw new TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException();
        }

        //check that 28-day hrs are not more than 90-day hrs
        if(simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getNinetyDayHrs() ){
                    throw new TwentyEightDayHrsGreaterThan90DayHrsException();
        }

        Loader loader = new Loader();

        //check existing user and save simulation
        if(user.isPresent()) {
            Simulation simulation = new Simulation(
                    size + 1,
                    simulationInputDTO.getLastInput(),
                    user.get(),
                    simulationInputDTO.getAgeAircraft(),
                    simulationInputDTO.getNoOfPassengers(),
                    simulationInputDTO.getPicLicence(),
                    simulationInputDTO.getPicAge(),
                    simulationInputDTO.getTotalHrs(),
                    simulationInputDTO.getTypeHrs(),
                    simulationInputDTO.getNinetyDayHrs(),
                    simulationInputDTO.getTwentyEightDayHrs(),
                    null,
                    loader.load8(simulationInputDTO).get(0),
                    null,
                    loader.load8(simulationInputDTO).get(1));
            return simulationRepository.save(simulation);
        } else {
            return null;
        }
    }

    public Simulation addSimulation9(SimulationInputDTO simulationInputDTO) throws Exception {
        int size = simulationRepository.findAll().size();

        //check date of last input is not after today's date
        LocalDate now = LocalDate.now();
        if(simulationInputDTO.getLastInput().isAfter(now)){
            throw new LastInputDateIsAfterDateTodayException();
        }

        //check that type, 90-day and 28-day hrs are not more than total hrs
        if(  (simulationInputDTO.getTypeHrs()>simulationInputDTO.getTotalHrs() || simulationInputDTO.getNinetyDayHrs()>simulationInputDTO.getTotalHrs()) ||
                simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getTotalHrs() ){
            throw new TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException();
        }

        //check that 28-day hrs are not more than 90-day hrs
        if(simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getNinetyDayHrs() ){
            throw new TwentyEightDayHrsGreaterThan90DayHrsException();
        }

        Loader loader = new Loader();

        Simulation simulation = new Simulation(
                size + 1,
                simulationInputDTO.getLastInput(),
                simulationInputDTO.getUser(),
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
                loader.load9(simulationInputDTO).get(0),
                loader.load9(simulationInputDTO).get(1));
        return simulationRepository.save(simulation);
    }

    public Simulation updateSimulation(int simulationId, SimulationInputDTO simulationInputDTO) throws Exception {
        Optional<Simulation> originalSimulation = simulationRepository.findById(simulationId);

        if (!originalSimulation.isPresent()) {
            return null;
        }

        Simulation simulationEntity = originalSimulation.get();
        Loader loader = new Loader();

        //check that type, 90-day and 28-day hrs are not more than total hrs
        if(  (simulationInputDTO.getTypeHrs()>simulationInputDTO.getTotalHrs() || simulationInputDTO.getNinetyDayHrs()>simulationInputDTO.getTotalHrs()) ||
                simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getTotalHrs() ){
            throw new TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException();
        }

        //check that 28-day hrs are not more than 90-day hrs
        if(simulationInputDTO.getTwentyEightDayHrs()>simulationInputDTO.getNinetyDayHrs() ){
            throw new TwentyEightDayHrsGreaterThan90DayHrsException();
        }

        //INPUT UPDATE CHANGES INTO ENTITY
        simulationEntity.setLastInput(LocalDate.now());
        //user id unchanged
        simulationEntity.setAgeAircraft(simulationInputDTO.getAgeAircraft());
        simulationEntity.setNoOfPassengers(simulationInputDTO.getNoOfPassengers());
        simulationEntity.setPicLicence(simulationInputDTO.getPicLicence());
        simulationEntity.setPicAge(simulationInputDTO.getPicAge());
        simulationEntity.setTotalHrs(simulationInputDTO.getTotalHrs());
        simulationEntity.setTypeHrs(simulationInputDTO.getTypeHrs());
        simulationEntity.setNinetyDayHrs(simulationInputDTO.getNinetyDayHrs());
        simulationEntity.setTwentyEightDayHrs(simulationInputDTO.getTwentyEightDayHrs());
        if(simulationInputDTO.getDayOfWeek() != null) {
            simulationEntity.setDayOfWeek(simulationInputDTO.getDayOfWeek());
            simulationEntity.setInjurySeverity(loader.load9(simulationInputDTO).get(0));
            simulationEntity.setProbability(loader.load9(simulationInputDTO).get(1));
        } else {
            simulationEntity.setAccidentSeverity(loader.load8(simulationInputDTO).get(0));
            simulationEntity.setProbability(loader.load8(simulationInputDTO).get(1));
        }

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
