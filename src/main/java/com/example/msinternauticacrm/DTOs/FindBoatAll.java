package com.example.msinternauticacrm.DTOs;

import com.example.msinternauticacrm.models.Announcement;
import com.example.msinternauticacrm.models.Owner;
import com.example.msinternauticacrm.models.Sailor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record FindBoatAll(
        String id,
        String photo,
        String name,
        String manufacturer,
        String model,
        Double size,
        Integer year,
        String engines,
        String engine,
        Integer hours,
        String marina,
        Double value,
        String collector,
        String status
) {}
