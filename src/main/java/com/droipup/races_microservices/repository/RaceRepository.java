package com.droipup.races_microservices.repository;

import com.droipup.races_microservices.dto.RaceDayDTO;
import com.droipup.races_microservices.dto.RaceDetailBaseDTO;
import com.droipup.races_microservices.dto.RaceDetailDTO;
import com.droipup.races_microservices.dto.RacesListDTO;
import com.droipup.races_microservices.model.Races;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Races, String> {
   @Query("SELECT new com.droipup.races_microservices.dto.RacesListDTO(r.id, r.name, r.organizer) FROM Races r")
   List<RacesListDTO> findAllRaces();

   @Query("""
           SELECT new com.droipup.races_microservices.dto.RaceDetailBaseDTO(
           r.id,r.name, r.description, r.organizer, r.eventLink, r.totalDistance, r.totalElevation,
            d.name, p.name, de.name, r.startDate, r.endDate
           ) FROM Races r 
           JOIN r.districts d
           JOIN d.provinces p
           JOIN p.departments de
           WHERE r.id = :raceId
           """)
   Optional<RaceDetailBaseDTO> findRacebyId(@Param("raceId") String raceId);


   @Query("""
           SELECT new com.droipup.races_microservices.dto.RaceDayDTO(
           rd.distance,rd.elevation, rd.routeLink)
           FROM RacesDays rd
           WHERE rd.races.id = :raceId""")
   List<RaceDayDTO> findRaceDaysById(@Param("raceId") String raceId);
}
