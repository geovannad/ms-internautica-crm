package com.example.msinternauticacrm.controllers;

import com.example.msinternauticacrm.DTOs.LoginDTO;
import com.example.msinternauticacrm.config.SecurityConfig;
import com.example.msinternauticacrm.models.Adm;
import com.example.msinternauticacrm.repositories.AdmRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@RestController
@NoArgsConstructor
public class TokenController {

    @Autowired
    private AdmRepository admRepository;
    @Autowired
    public SecretKey secretKey;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenController(AdmRepository admRepository, SecretKey secretKey, PasswordEncoder passwordEncoder) {
        this.admRepository = admRepository;
        this.secretKey = secretKey;
        this.passwordEncoder = passwordEncoder;
    }

   @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginDTO loginRequest) {
        boolean existAdm = admRepository.existsByEmail(loginRequest.email());
        if(existAdm) {
            Optional<Adm> adm = admRepository.findAdmByEmail(loginRequest.email());
            if (passwordEncoder.matches(loginRequest.password(), adm.get().getPassword())) {
                try {
                    String token = Jwts.builder()
                            .setSubject(loginRequest.email())
                            .claim("auth", Collections.emptyList())
                            .setExpiration(new Date(System.currentTimeMillis() + 86_400_000))
                            .signWith(secretKey, SignatureAlgorithm.HS512)
                            .compact();
                    return ResponseEntity.ok("Bearer " + token);
                } catch (Exception e) {
                    return new ResponseEntity<>("Error generating token JWT", HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>("Invalid credentials - password", HttpStatus.UNAUTHORIZED);
            }
        }else {
            return new ResponseEntity<>("Invalid credentials - email", HttpStatus.UNAUTHORIZED);
        }
    }




}
