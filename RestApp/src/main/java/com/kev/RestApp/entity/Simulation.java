package com.kev.RestApp.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime lastInput;

    private int noOfAttributes;
    private String dayOfWeek;
    private String accidentSeverity;
    private String injurySeverity;

}
