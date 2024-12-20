package com.example.msinternauticacrm.repositories;

import com.example.msinternauticacrm.models.Boat;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface BoatRepository extends Repository<Boat, String>, MongoRepository<Boat, String>, PagingAndSortingRepository<Boat, String> {

    Boat findBoatsByIdBoat(int idBoat);
    boolean existsBoatByIdBoat(int idBoat);

    void deleteBoatByIdBoat(int idBoat);


}
