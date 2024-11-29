package com.example.msinternauticacrm.services;

import com.example.msinternauticacrm.models.Adm;
import com.example.msinternauticacrm.repositories.AdmRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class CustomAdmDetailService implements UserDetailsService {

    private AdmRepository admRepository;
    public CustomAdmDetailService( AdmRepository admRepository){
        this.admRepository = admRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<Adm> adm = admRepository.findAdmByEmail(email);
        List<GrantedAuthority> authorities =  Collections.emptyList();

        return new org.springframework.security.core.userdetails.User(
                adm.get().getEmail(),
                adm.get().getPassword(), // Define uma senha dummy sem criptografia
                true,
                true,
                true,true, authorities

        );


    }
}
