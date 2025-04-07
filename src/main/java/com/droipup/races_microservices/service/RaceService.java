package com.droipup.races_microservices.service;

import com.droipup.races_microservices.dto.RaceDayDTO;
import com.droipup.races_microservices.dto.RaceDetailBaseDTO;
import com.droipup.races_microservices.dto.RaceDetailDTO;
import com.droipup.races_microservices.dto.RacesListDTO;
import com.droipup.races_microservices.repository.RaceRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public List<RacesListDTO> getAllRaces(){
        return  raceRepository.findAllRaces();
    }

//    public Optional<RaceDetailDTO> getRaceDetail(String id){
//        return raceRepository.findRacebyId(id);
//    }

    public Optional<RaceDetailDTO> getRaceDetailWithDays(String raceId){
        Optional<RaceDetailBaseDTO> base = raceRepository.findRacebyId(raceId);
        if (base.isEmpty()) return Optional.empty();

        List<RaceDayDTO> raceDays = raceRepository.findRaceDaysById(raceId);

        RaceDetailBaseDTO b = base.get();
        RaceDetailDTO dto = new RaceDetailDTO(
                b.name(),
                b.description(),
                b.organizer(),
                b.eventLink(),
                b.totalDistance(),
                b.totalElevation(),
                b.district(),
                b.province(),
                b.department(),
                b.startDate(),
                b.endDate(),
                raceDays
        );

        return Optional.of(dto);
    }
}
