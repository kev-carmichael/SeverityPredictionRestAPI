package com.kev.RestApp.simulation;

import com.kev.RestApp.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation, Integer> {

}
