package com.example.msinternauticacrm.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Owner {
    private String ownerName;
    private String ownerNumber;
    @Email(message = "Owner email must be valid.")
    private String ownerEmail;
}
