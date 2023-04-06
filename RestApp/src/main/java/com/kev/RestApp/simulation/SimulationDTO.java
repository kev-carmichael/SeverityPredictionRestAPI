package com.kev.RestApp.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

public class SimulationDTO {

    private final int simulationId;
    private final LocalDateTime lastInput;


}
