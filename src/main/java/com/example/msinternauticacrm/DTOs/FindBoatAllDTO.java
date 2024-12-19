package com.example.msinternauticacrm.DTOs;

public record FindBoatAllDTO(
        String id,
        String photo,
        String name,
        String manufacturer,
        String model,
        Double size,
        Integer year,
        Integer engines,
        String engine,
        Integer hours,
        String marina,
        Double value,
        String collector,
        String status
) {}
