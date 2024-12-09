package com.example.msinternauticacrm.controllers;

import com.example.msinternauticacrm.DTOs.SaveAdmDTO;
import com.example.msinternauticacrm.DTOs.UpdatePasswordDTO;
import com.example.msinternauticacrm.models.Adm;
import com.example.msinternauticacrm.services.AdmService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/adm")
public class AdmController {

    private AdmService admService;

    @PostMapping("/create-adm")
    public ResponseEntity<Adm> createAdm(
            @RequestBody @Valid SaveAdmDTO request) {
        Adm adm = admService.createAdm(request.email(), request.password(), request.name());
        return ResponseEntity.ok(adm);
    }
    @PutMapping("/update-password")
    public ResponseEntity<Adm> updatePassword(
            @RequestBody @Valid UpdatePasswordDTO request) {
        Adm adm = admService.updatePassword(request.email(), request.newPassword());
        return ResponseEntity.ok(adm);
    }

    // Endpoint para deletar um Adm por email
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdm(@RequestParam String email) {
        try {
            boolean deleted = admService.delete(email);
            if (deleted) {
                return ResponseEntity.ok("Adm deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adm not found.");
            }
        } catch (Exception e) {
            // Log o erro para análise
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting Adm.");
        }
    }

    
    @GetMapping("/api")
    public ResponseEntity<?>  conect() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
