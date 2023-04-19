package com.kev.RestAPI.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter


public class SimulationInputDTO {

    private final LocalDate lastInput;
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
