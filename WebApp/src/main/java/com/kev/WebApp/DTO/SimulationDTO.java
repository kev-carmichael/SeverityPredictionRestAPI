package com.kev.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

public class SimulationDTO {

    private final int simulationId;
    private String lastInput; //can't be final
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

    @JsonCreator
    public SimulationDTO(@JsonProperty("simulationId") int simulationId,
                         @JsonProperty("ageAircraft") int ageAircraft,
                         @JsonProperty("noOfPassengers")int noOfPassengers,
                         @JsonProperty("picLicence")String picLicence,
                         @JsonProperty("picAge")int picAge,
                         @JsonProperty("totalHrs")int totalHrs,
                         @JsonProperty("typeHrs")int typeHrs,
                         @JsonProperty("ninetyDayHrs")int ninetyDayHrs,
                         @JsonProperty("twentyEightDayHrs")int twentyEightDayHrs,
                         @JsonProperty("dayOfWeek")String dayOfWeek,
                         @JsonProperty("accidentSeverity")String accidentSeverity,
                         @JsonProperty("injurySeverity")String injurySeverity) {
        this.simulationId = simulationId;
        this.ageAircraft = ageAircraft;
        this.noOfPassengers = noOfPassengers;
        this.picLicence = picLicence;
        this.picAge = picAge;
        this.totalHrs = totalHrs;
        this.typeHrs = typeHrs;
        this.ninetyDayHrs = ninetyDayHrs;
        this.twentyEightDayHrs = twentyEightDayHrs;
        this.dayOfWeek = dayOfWeek;
        this.accidentSeverity = accidentSeverity;
        this.injurySeverity = injurySeverity;
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s, %s",
                picLicence,
                accidentSeverity);
    }



}
