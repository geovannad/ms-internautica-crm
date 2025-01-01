package com.example.msinternauticacrm.models;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Field(name = "id_boat")
    private int idBoat;

    private List<String> photos;

    @NotBlank(message = "Manufacturer is required.")
    private String manufacturer;

    @NotBlank(message = "Model is required.")
    private String model;

    
    @DecimalMin(value = "0.1", message = "Size must be greater than 0.")
    private Double size;

    
    @Min(value = 1900, message = "Year must be after 1900.")
    @Max(value = 2100, message = "Year must be before 2100.")
    @Field(name = "year_engine")
    private Integer year;

    
    @Field(name = "name_vessel")
    private String nameVessel;

    private String marina;

    
    @DecimalMin(value = "0.0", message = "Value must be non-negative.")
    private Double value;

    private String mark;

    
    @Min(value = 0, message = "Amount must be non-negative.")
    private Integer amount;


    @Field(name = "model_power")
    private String modelPower;

    
    @Min(value = 1900, message = "Engine year must be after 1900.")
    @Max(value = 2100, message = "Engine year must be before 2100.")
    private Integer yearEngine;

    
    @Min(value = 0, message = "Hours must be non-negative.")
    private Integer hours;

    private String fuel;
    
    private Boolean ips;
    
    private Boolean surface;

    
    private Boolean bridle;

    
    private Boolean stern;

    private String outdrive;

    private List<String> pickups;

    @Embedded
    @Valid
    private Sailor sailor;

    @Embedded
    @Valid
    private Owner owner;

    @Embedded
    private Announcement announcement;

    
    private List<String> keywords;

    @ElementCollection
    private List<String> equipment;

    
    private String status;

    private String observationsAdm;
    private String observationsPublish;

}
