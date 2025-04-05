package com.droipup.races_microservices.controller;

import com.droipup.races_microservices.dto.RaceDetailDTO;
import com.droipup.races_microservices.dto.RacesListDTO;
import com.droipup.races_microservices.service.RaceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {
    @Autowired
    private RaceService raceService;

    @GetMapping
    public List<RacesListDTO> getAll() {return raceService.getAllRaces();}

    @GetMapping("/{id}")
    public ResponseEntity<RaceDetailDTO> getRaceDetail(@PathVariable String id){
        return raceService.getRaceDetailWithDays(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
