package com.kev.RestAPI.simulation;

import com.kev.RestAPI.factory.DTOFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SimulationControllerTest {

    @Test
    void t9_when_GetSimulationList_Expect_OneCallToSimulationService() {
        SimulationService mockSimulationService = mock(SimulationService.class);
        DTOFactory mockDTOFactory = mock(DTOFactory.class);

        SimulationController simulationController = new SimulationController
                (mockSimulationService, mockDTOFactory);

        simulationController.getSimulationList();

        verify(mockSimulationService, times(1)).getSimulationList();
        verifyNoMoreInteractions(mockSimulationService);
    }


}