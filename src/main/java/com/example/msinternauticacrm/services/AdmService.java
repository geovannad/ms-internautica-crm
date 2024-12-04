package com.example.msinternauticacrm.services;

import com.example.msinternauticacrm.exception.NotFound;
import com.example.msinternauticacrm.models.Adm;
import com.example.msinternauticacrm.repositories.AdmRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdmService {

    private AdmRepository admRepository;
    private PasswordEncoder passwordEncoder;

    public Adm createAdm (String email, String password, String name){
        boolean existEmail = admRepository.existsByEmail(email);
        if(!existEmail) {
            Adm adm = Adm.builder()
                    .name(name)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .build();
            return adm = admRepository.save(adm);
        }
        throw new IllegalArgumentException("This email already being used ");

    }

    public Adm updatePassword(String email, String newPassword) {
        Optional<Adm> adm = admRepository.findAdmByEmail(email);
        if (adm != null) {
            adm.get().setPassword(passwordEncoder.encode(newPassword));
            return admRepository.save(adm.get());
        }
        throw new NotFound("Adm not found with id: " + adm.get().getEmail());
    }

    public boolean delete(String email) {
        Optional<Adm> adm = admRepository.findAdmByEmail(email);
        if (adm != null) {
            admRepository.deleteById(adm.get().getId());

            Optional<Adm> admDelete = admRepository.findAdmByEmail(email);
            if(admDelete != null){
                return true;
            }
            return false;
        }
            throw new NotFound("Adm not found with id: " + adm.get().getEmail());

    }

}
