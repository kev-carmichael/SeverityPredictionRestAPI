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

    private final String target;
    private final int noOfAttributes;
    private final String dayOfWeek;
    private final String accidentSeverity;
    private final String injurySeverity;


}
