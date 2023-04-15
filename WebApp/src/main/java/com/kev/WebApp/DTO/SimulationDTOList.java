package com.kev.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


//@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter


public class SimulationDTOList {

    private List<SimulationDTO> list;

    @JsonCreator
    public SimulationDTOList(@JsonProperty("list") List<SimulationDTO> list){
        this.list = list;
    }


}


