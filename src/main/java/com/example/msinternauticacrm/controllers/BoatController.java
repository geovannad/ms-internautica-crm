package com.example.msinternauticacrm.controllers;

import com.example.msinternauticacrm.models.Boat;
import com.example.msinternauticacrm.services.BoatService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/boat")
public class BoatController {

    private BoatService boatService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Boat>> findAll(){
        return new ResponseEntity<>(boatService.listBoats(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boat> createBoat(@Valid @RequestBody Boat boat) {
        Boat createdBoat = boatService.createBoat(boat);
        return new ResponseEntity<>(createdBoat, HttpStatus.CREATED);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Boat> getBoatById(@PathVariable Long id) {
        Boat boat = boatService.getBoatById(id);
        return new ResponseEntity<>(boat, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boat> updateBoat(@PathVariable Long id, @Valid @RequestBody Boat boatDetails) {
        Boat updatedBoat = boatService.updateBoat(id, boatDetails);
        return new ResponseEntity<>(updatedBoat, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoat(@PathVariable Long id) {
        boolean isDeleted = boatService.deleteBoat(id);
        if (isDeleted) {
            return new ResponseEntity<>("Boat deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Boat not found.", HttpStatus.NOT_FOUND);
    }

}
