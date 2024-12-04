package com.example.msinternauticacrm.DTOs;

import jakarta.validation.constraints.NotNull;

public record UpdatePasswordDTO(
        @NotNull
        String email,
        @NotNull
        String newPassword

) {
}
