package com.example.msinternauticacrm.controllers;

import com.example.msinternauticacrm.models.Boat;
import com.example.msinternauticacrm.repositories.BoatRepository;
import com.example.msinternauticacrm.services.BoatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boat-teste")
public class NewControllerTeste {

    private BoatService boatRepository;

    public NewControllerTeste(BoatService boatRepository) {
        this.boatRepository = boatRepository;
    }

    @PostMapping("/create-boats")
    public ResponseEntity<Boat> create(@RequestBody Boat boat){
        Boat newBoat = boatRepository.createBoat(boat);
        return ResponseEntity.ok(newBoat);
    }



}
