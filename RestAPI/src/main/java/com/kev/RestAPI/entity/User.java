package com.kev.RestAPI.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String email;

    private String password;

    private String token;

    @OneToMany(mappedBy = "user")
    @OrderBy(value = "simulationId")
    private List<Simulation> simulations;



    @Override
    public String toString() {
        return String.format(
                "%s, %s",
                userId,
                email);
    }

    public int getSimulationCount() {
        return simulations.size();
    }



}
