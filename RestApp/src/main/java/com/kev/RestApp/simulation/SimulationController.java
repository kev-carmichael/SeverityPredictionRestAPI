package com.kev.RestApp.simulation;


import com.kev.RestApp.dto.Result;
import com.kev.RestApp.util.Loader;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/simulation")
@AllArgsConstructor
public class SimulationController {

    private final SimulationService simulationService;

    @GetMapping(path="/all")
    public List<SimulationDTO> getSimulationList(){
        return simulationService.getSimulationList();
    }

    @PostMapping(path = "/run7")
    public Result returnResult7(@RequestBody ArrayList<String> simulationData) throws Exception {
        Loader loader = new Loader();

        return new Result(loader.load(simulationData));
    }

    @PostMapping(path = "/run8")
    public Result returnResult8(@RequestBody ArrayList<String> simulationData) throws Exception {
        Loader loader = new Loader();

        return new Result(loader.load(simulationData));
    }


}
