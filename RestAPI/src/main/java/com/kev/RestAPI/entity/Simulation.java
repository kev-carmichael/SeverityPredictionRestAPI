package com.kev.RestAPI.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "simulation")
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int simulationId;

    private LocalDate lastInput;

//    @ManyToOne
//    @JoinColumn(name = "user", nullable = false)
//    private User user;

    private int ageAircraft;
    private int noOfPassengers;
    private String picLicence;
    private int picAge;
    private int totalHrs;
    private int typeHrs;
    private int ninetyDayHrs;
    private int twentyEightDayHrs;
    private String dayOfWeek;
    private String accidentSeverity;
    private String injurySeverity;

}
