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
        double size,
        int year,
        String engines,
        String engine,
        int hours,
        String marina,
        double value,
        String collector,
        String status
) {}
