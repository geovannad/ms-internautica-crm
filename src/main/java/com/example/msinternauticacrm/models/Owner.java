package com.example.msinternauticacrm.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Owner {
    @NotBlank(message = "Owner name is required.")
    private String name;

    @NotBlank(message = "Owner number is required.")
    private String number;

    @Email(message = "Owner email must be valid.")
    private String email;
}
