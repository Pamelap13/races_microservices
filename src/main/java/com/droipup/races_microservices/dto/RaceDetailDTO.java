package com.droipup.races_microservices.dto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public record RaceDetailDTO(String name, String description,
                            String organizer, String eventLink, Double totalDistance,
                            Double totalElevation, String district, String province, String department,
                            List<RaceDayDTO> raceDays) {
}
