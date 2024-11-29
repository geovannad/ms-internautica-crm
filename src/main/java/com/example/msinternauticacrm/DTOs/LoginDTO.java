package com.example.msinternauticacrm.DTOs;

import jakarta.validation.constraints.NotNull;

public record LoginDTO (
        @NotNull
        String email,
        @NotNull
        String password
){
}
