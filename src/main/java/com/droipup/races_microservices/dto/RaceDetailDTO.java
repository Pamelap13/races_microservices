package com.droipup.races_microservices.dto;

public record RaceDetailDTO(String name, String description,
                            String organizer, String eventLink, Double totalDistance,
                            Double totalElevation, String district, String province, String department
) {
}
