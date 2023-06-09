package com.kev.RestAPI.simulation;

import com.kev.RestAPI.entity.User;
import com.kev.RestAPI.exception.*;
import com.kev.RestAPI.factory.DTOFactory;
import com.kev.RestAPI.user.UserRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SimulationServiceTest {

    @Test
    void t1_when_lastInputIsAfterToday_Expect_LastInputDateIsAfterDateTodayException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now().plusDays(1),
                mock(User.class), 1, 1,
                "student", 21, 10, 1,
                1, 1, null);

        assertThrows(
                LastInputDateIsAfterDateTodayException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t2_when_28DayHrsAreGreaterThan90DayHrs_Expect_TwentyEightDayHrsGreaterThan90DayHrsException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "student", 21, 10, 1,
                1, 2, null);

        assertThrows(
                TwentyEightDayHrsGreaterThan90DayHrsException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t3_when_TypeHrsAreGreaterThanTotalHrs_Expect_TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "student", 21, 10, 11,
                1, 1, null);

        assertThrows(
                TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t4_when_90DayHrsAreGreaterThanTotalHrs_Expect_TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "student", 21, 10, 1,
                11, 1, null);

        assertThrows(
                TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t5_when_28DayHrsAreGreaterThanTotalHrs_Expect_TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "student", 21, 10, 1,
                1, 11, null);

        assertThrows(
                TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t6_when_PicAgeIsLessThan21AndAirlineTransportLicence_Expect_PicAgeLessThan21AndAirlineTransportLicenceException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "airline transport licence", 20, 10, 1,
                1, 1, null);

        assertThrows(
                PicAgeLessThan21AndAirlineTransportLicenceException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

    @Test
    void t7_when_PicAgeIsLessThan17AndPrivatePilotLicence_Expect_PicAgeLess17AndPrivatePilotLicenceException() {

        SimulationRepository mockSimulationRepository = mock(SimulationRepository.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);
        UserRepository mockUserRepository = mock(UserRepository.class);

        SimulationService simulationService = new SimulationService(mockDTOFactory,
                mockSimulationRepository, mockUserRepository);

        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                LocalDate.now(),
                mock(User.class), 1, 1,
                "private pilot licence", 16, 10, 1,
                1, 1, null);

        assertThrows(
                PicAgeLess17AndPrivatePilotLicenceException.class,
                () -> simulationService.addSimulation8(simulationInputDTO));
    }

}