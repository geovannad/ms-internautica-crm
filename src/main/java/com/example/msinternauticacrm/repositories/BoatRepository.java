package com.example.msinternauticacrm.repositories;

import com.example.msinternauticacrm.models.Boat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface BoatRepository extends Repository<Boat, String>, MongoRepository<Boat, String>, PagingAndSortingRepository<Boat, String> {

    Boat findBoatsByIdBoat(Long idBoat);
    boolean existsBoatByIdBoat(Long idBoat);

    void deleteBoatByIdBoat(Long idBoat);

}
