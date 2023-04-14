package com.kev.RestApp.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter


public class SimulationInputDTO {

//    private final LocalDateTime lastInput;
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

}
