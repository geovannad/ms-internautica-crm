package com.example.msinternauticacrm.services;

import com.example.msinternauticacrm.DTOs.FindBoatAllDTO;
import com.example.msinternauticacrm.exception.NotFound;
import com.example.msinternauticacrm.models.Boat;
import com.example.msinternauticacrm.repositories.BoatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Boat createBoat(Boat boat) {

        return boatRepository.save(boat);
    }


    public Boat getBoatById(Long id) {
        return boatRepository.findBoatsByIdBoat(id);
    }


    public Boat updateBoat(Long id, Boat boatDetails) {
        Boat existingBoat = boatRepository.findBoatsByIdBoat(id);

        if(existingBoat == null){
            throw new NotFound("Not found boat");
        }

        BeanUtils.copyProperties(boatDetails, existingBoat, "idBoat");
        return boatRepository.save(existingBoat);
    }

    public boolean deleteBoat(Long id) {
        if (boatRepository.existsBoatByIdBoat(id)) {
            boatRepository.deleteBoatByIdBoat(id);
            return true;
        }
        return false;
    }

    public List<FindBoatAllDTO> listBoats() {
        List<Boat> resultRepository = boatRepository.findAll();

        List<FindBoatAllDTO> result = resultRepository.stream()
                .map(boat -> new FindBoatAllDTO(
                        boat.getId(),
                        boat.getPhotos().get(0),
                        boat.getNameVessel(),
                        boat.getManufacturer(),
                        boat.getModel(),
                        boat.getSize(),
                        boat.getYear(),
                        boat.getAmount(),
                        boat.getModelPower(),
                        boat.getHours(),
                        boat.getMarina(),
                        boat.getValue(),
                        boat.getPickups(),
                        boat.getStatus()
                ))
                .collect(Collectors.toList());

        return result;
    }


}
