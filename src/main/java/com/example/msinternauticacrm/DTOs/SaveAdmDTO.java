package com.example.msinternauticacrm.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record SaveAdmDTO(
        @NotNull
        String name,
        @NotNull
        String email,
        @NotNull
        String password
) {
}
