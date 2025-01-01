package com.example.msinternauticacrm.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Announcement {
    
    private Boolean announceSite;

    private Boolean announceMercadoLivre;

    private Boolean announceBombarco;

    private Boolean announceInstagram;
}
