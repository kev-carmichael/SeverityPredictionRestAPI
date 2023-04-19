package com.kev.RestAPI.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter


public class SimulationInputDTO {

    @NotNull(message = "lastInput date must be present")
    private final LocalDate lastInput;
//    private final String user;

    @Min(value = 0, message = "ageAircraft must be equal to or higher than 0")
    @Max(value = 88, message = "ageAircraft must be equal to or less than 88")
    private final int ageAircraft;

    @Min(value = 0, message = "ageAircraft must be equal to or higher than 0")
    @Max(value = 6, message = "ageAircraft must be equal to or less than 6")
    private final int noOfPassengers;

    private final String picLicence;

    @Min(value = 16, message = "ageAircraft must be equal to or higher than 16")
    @Max(value = 88, message = "ageAircraft must be equal to or less than 88")
    private final int picAge;

    @Min(value = 10, message = "ageAircraft must be equal to or higher than 10")
    @Max(value = 31500, message = "ageAircraft must be equal to or less than 31500")
    private final int totalHrs;

    @Min(value = 0, message = "ageAircraft must be equal to or higher than 0")
    @Max(value = 13500, message = "ageAircraft must be equal to or less than 31500")
    private final int typeHrs;

    @Min(value = 0, message = "ageAircraft must be equal to or higher than 0")
    @Max(value = 305, message = "ageAircraft must be equal to or less than 305")
    private final int ninetyDayHrs;

    @Min(value = 0, message = "ageAircraft must be equal to or higher than 0")
    @Max(value = 140, message = "ageAircraft must be equal to or less than 140")
    private final int twentyEightDayHrs;

    private final String dayOfWeek;

}
