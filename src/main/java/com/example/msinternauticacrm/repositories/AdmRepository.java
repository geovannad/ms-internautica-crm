package com.example.msinternauticacrm.repositories;

import com.example.msinternauticacrm.models.Adm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface AdmRepository  extends Repository<Adm, String>, MongoRepository<Adm, String> {

    Optional<Adm> findAdmByEmail(String email);
    boolean existsByEmail(String email);
}
