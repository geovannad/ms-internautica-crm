package com.example.msinternauticacrm.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Sailor {
    private String sailorName;
    private String sailorNumber;
    @Email(message = "Sailor email must be valid.")
    private String sailorEmail;
}