package com.kev.WebApp.web;

import com.kev.WebApp.DTO.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class WebSimulationController {
    ArrayList<String> simulationData = new ArrayList<>();

    @GetMapping(path = "/web/simulation/start")
    public String selectSimulationType() {
        return "index";
    }




    @GetMapping(path = "/web/simulation/run8")
    public String runSimulation8(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter8values";
    }

    @GetMapping(path = "/web/simulation/run9")
    public String runSimulation9(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter9values";
    }


    @PostMapping(path = "/web/simulation/run8")
    public String runSimulation8(@ModelAttribute SimulationInput simulationInput, Model model) {
        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                Integer.parseInt(simulationInput.getText0()),
                Integer.parseInt(simulationInput.getText1()),
                simulationInput.getText2(),
                Integer.parseInt(simulationInput.getText3()),
                Integer.parseInt(simulationInput.getText4()),
                Integer.parseInt(simulationInput.getText5()),
                Integer.parseInt(simulationInput.getText6()),
                Integer.parseInt(simulationInput.getText7()),
                null);

        SimulationDTO simulationDTO =
                new RestTemplateBuilder()
                        .build()
                        .postForObject(
                                "http://localhost:8080/rest/simulation/run8",
                                simulationInputDTO,
                                SimulationDTO.class);

        model.addAttribute(
                "simulationResult",
                new SimulationResult(simulationInput.getText2(), simulationDTO.getAccidentSeverity()));

        return "result";
    }

    /*@PostMapping(path = "/web/simulation/run9")
    public String runSimulation9(@ModelAttribute SimulationInput simulationInput, Model model) {
        simulationData.clear();
        simulationData.add(simulationInput.getText0());
        simulationData.add(simulationInput.getText1());
        simulationData.add(simulationInput.getText2());
        simulationData.add(simulationInput.getText3());
        simulationData.add(simulationInput.getText4());
        simulationData.add(simulationInput.getText5());
        simulationData.add(simulationInput.getText6());
        simulationData.add(simulationInput.getText7());
        simulationData.add(simulationInput.getText8());

        Result result =
                new RestTemplateBuilder()
                        .build()
                        .postForObject(
                                "http://localhost:8080/rest/simulation/run9",
                                simulationData,
                                Result.class);

        model.addAttribute(
                "simulationResult",
                new SimulationResult(simulationInput.getText2(), result.getResults()));

        return "result";
    }*/
}
