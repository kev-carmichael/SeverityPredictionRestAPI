package com.kev.RestAPI.simulation;

import com.kev.RestAPI.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation, Integer> {

}
