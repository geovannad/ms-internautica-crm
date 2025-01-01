package com.example.msinternauticacrm.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Owner {
    
    private String name;

    private String number;

    @Email(message = "Owner email must be valid.")
    private String email;
}
