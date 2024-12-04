package com.example.msinternauticacrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "adm")
public class Adm {

    @Id
    private String id;
    @NotNull(message = "Name cannot be null")
    @Column(unique = true)
    private String name;
    @Email
    @NotNull(message = "Email cannot be null")
    @Column(unique = true)
    private String email;
    @NotNull(message = "Password cannot be null")
    private String password;
}
