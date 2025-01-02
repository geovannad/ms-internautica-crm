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


    public Boat getBoatById(int id) {
        return boatRepository.findBoatsByIdBoat(id);
    }


    public Boat updateBoat(int id, Boat boatDetails) {
        Boat existingBoat = boatRepository.findBoatsByIdBoat(id);

        if(existingBoat == null){
            throw new NotFound("Not found boat");
        }

        BeanUtils.copyProperties(boatDetails, existingBoat, "idBoat");
        return boatRepository.save(existingBoat);
    }

    public boolean deleteBoat(int id) {
        if (boatRepository.existsBoatByIdBoat(id)) {
            boatRepository.deleteBoatByIdBoat(id);
            return true;
        }
        return false;
    }

    public List<FindBoatAllDTO> listBoats() {
    List<Boat> resultRepository = boatRepository.findAll();

    List<FindBoatAllDTO> result = resultRepository.stream()
            .map(boat -> {
                String photo = "";
                String ownerEmail = "";
                String boatName = "";
                String manufacturer = "";
                String model = "";
                String modelPower = "";
                String marina = "";
                String status = "";
                
                if (boat.getPhotos() != null && !boat.getPhotos().isEmpty()) {
                    photo = boat.getPhotos().get(0);
                }

                if (boat.getOwner() != null && boat.getOwner().getEmail() != null) {
                    ownerEmail = boat.getOwner().getEmail();
                }

                if (boat.getNameVessel() != null) {
                    boatName = boat.getNameVessel();
                }

                if (boat.getManufacturer() != null) {
                    manufacturer = boat.getManufacturer();
                }

                if (boat.getModel() != null) {
                    model = boat.getModel();
                }

                if (boat.getModelPower() != null) {
                    modelPower = boat.getModelPower();
                }

                if (boat.getMarina() != null) {
                    marina = boat.getMarina();
                }

                if (boat.getStatus() != null) {
                    status = boat.getStatus();
                }

                return new FindBoatAllDTO(
                        boat.getIdBoat(),
                        photo,
                        boatName,
                        manufacturer,
                        model,
                        boat.getSize(),
                        boat.getYear(),
                        boat.getAmount(),
                        modelPower,
                        boat.getHours(),
                        marina,
                        boat.getValue(),
                        ownerEmail,
                        status
                );
            })
            .collect(Collectors.toList());

    return result;
}



}
