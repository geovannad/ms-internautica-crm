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
    @NotNull(message = "Announce site status is required.")
    private Boolean announceSite;

    @NotNull(message = "Announce Mercado Livre status is required.")
    private Boolean announceMercadoLivre;

    @NotNull(message = "Announce Bombarco status is required.")
    private Boolean announceBombarco;

    @NotNull(message = "Announce Instagram status is required.")
    private Boolean announceInstagram;
}
