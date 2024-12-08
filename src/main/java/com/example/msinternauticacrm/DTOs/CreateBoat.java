package com.example.msinternauticacrm.DTOs;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateBoat (
         @NotNull String manufacturer,
         @NotNull String model,
         @NotNull double size,
         @NotNull int year,
         @NotNull String nameVessel,
         @NotNull String marina,
         @NotNull double value,
         @NotNull String mark,
         @NotNull int amount,
         @NotNull double modelPower,
         @NotNull int yearEngine,
         @NotNull int hours,
         @NotNull double fuel,
         @NotNull boolean ips,
         @NotNull boolean bridle,
         @NotNull boolean stern,
         @NotNull String outdrive,
         @NotNull String pickups,
         @NotNull String sailor,
         @NotNull String numberSailor,
         @NotNull String emailSailor,
         @NotNull String owner,
         @NotNull String numberOwner,
         @NotNull String emailOwner,
         @NotNull boolean announceSite,
         @NotNull boolean announceMercadoLivre,
         @NotNull boolean announceBombarco,
         @NotNull boolean announceInstagram,
         @NotNull String observationsAdm,
         @NotNull String observationsPublish,
         @NotNull List<String> equipment,
         @NotNull String status,
         @NotNull List<String>keyword){
}
