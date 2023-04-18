package com.kev.RestAPI.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

public class SimulationDTO {

    private final int simulationId;
    private final String lastInput;
//    private final String user;
    private final int ageAircraft;
    private final int noOfPassengers;
    private final String picLicence;
    private final int picAge;
    private final int totalHrs;
    private final int typeHrs;
    private final int ninetyDayHrs;
    private final int twentyEightDayHrs;
    private final String dayOfWeek;
    private final String accidentSeverity;
    private final String injurySeverity;

}
