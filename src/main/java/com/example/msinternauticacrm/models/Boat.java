package com.example.msinternauticacrm.models;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "boats")
public class Boat {
    @Id
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoat;

    @NotBlank(message = "Manufacturer is required.")
    private String manufacturer;

    @NotBlank(message = "Model is required.")
    private String model;

    @NotNull(message = "Size is required.")
    @DecimalMin(value = "0.1", message = "Size must be greater than 0.")
    private Double size;

    @NotNull(message = "Year is required.")
    @Min(value = 1900, message = "Year must be after 1900.")
    @Max(value = 2100, message = "Year must be before 2100.")
    private Integer year;

    @NotBlank(message = "Vessel name is required.")
    private String nameVessel;

    private String marina;

    @NotNull(message = "Value is required.")
    @DecimalMin(value = "0.0", message = "Value must be non-negative.")
    private Double value;

    private String mark;

    @NotNull(message = "Amount is required.")
    @Min(value = 0, message = "Amount must be non-negative.")
    private Integer amount;

    @NotNull(message = "Model power is required.")
    @DecimalMin(value = "0.1", message = "Model power must be positive.")
    private Double modelPower;

    @NotNull(message = "Year of engine is required.")
    @Min(value = 1900, message = "Engine year must be after 1900.")
    @Max(value = 2100, message = "Engine year must be before 2100.")
    private Integer yearEngine;

    @NotNull(message = "Hours are required.")
    @Min(value = 0, message = "Hours must be non-negative.")
    private Integer hours;

    @NotNull(message = "Fuel is required.")
    @DecimalMin(value = "0.0", message = "Fuel must be non-negative.")
    private Double fuel;

    @NotNull(message = "IPS status is required.")
    private Boolean ips;

    @NotNull(message = "Bridle status is required.")
    private Boolean bridle;

    @NotNull(message = "Stern status is required.")
    private Boolean stern;

    private String outdrive;
    private String pickups;

    @Embedded
    @Valid
    private Sailor sailor;

    @Embedded
    @Valid
    private Owner owner;

    @Embedded
    private Announcement announcement;

    @NotEmpty(message = "At least one keyword is required.")
    private List<@NotBlank(message = "Keyword cannot be blank.") String> keywords;

    @ElementCollection
    private List<@NotBlank(message = "Equipment cannot be blank.") String> equipment;

    @NotBlank(message = "Status is required.")
    private String status;

    private String observationsAdm;
    private String observationsPublish;

}
