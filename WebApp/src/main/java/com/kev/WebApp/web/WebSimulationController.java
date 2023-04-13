package com.kev.WebApp.web;

import com.kev.WebApp.DTO.Result;
import com.kev.WebApp.DTO.SimulationInput;
import com.kev.WebApp.DTO.SimulationResult;
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
    public String runSimulation7(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter8values";
    }

    @GetMapping(path = "/web/simulation/run9")
    public String runSimulation8(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter9values";
    }


    @PostMapping(path = "/web/simulation/run8")
    public String runSimulation7(@ModelAttribute SimulationInput simulationInput, Model model) {
        simulationData.clear();
        simulationData.add(simulationInput.getText0());
        simulationData.add(simulationInput.getText1());
        simulationData.add(simulationInput.getText2());
        simulationData.add(simulationInput.getText3());
        simulationData.add(simulationInput.getText4());
        simulationData.add(simulationInput.getText5());
        simulationData.add(simulationInput.getText6());
        simulationData.add(simulationInput.getText7());

        Result result =
                new RestTemplateBuilder()
                        .build()
                        .postForObject(
                                "http://localhost:8080/rest/simulation/run8",
                                simulationData,
                                Result.class);

        model.addAttribute(
                "simulationResult",
                new SimulationResult(simulationInput.getText2(), result.getResults()));

        return "result";
    }

    @PostMapping(path = "/web/simulation/run9")
    public String runSimulation8(@ModelAttribute SimulationInput simulationInput, Model model) {
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
    }
}
