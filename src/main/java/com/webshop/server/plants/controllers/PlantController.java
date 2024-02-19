package com.webshop.server.plants.controllers;
import org.springframework.http.ResponseEntity;

import com.webshop.server.plants.entities.Plant;
import com.webshop.server.plants.repositories.PlantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class PlantController {
    private final PlantRepository plantRepository;

    public PlantController(final PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping()
    public String getMessage() {
        return "Hello";
    }

    @GetMapping("/plants")
    public ResponseEntity<?> getAllPlants() {
        try {
            Iterable<Plant> plants = this.plantRepository.findAll();
            return new ResponseEntity<>(plants, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving plants");
        }
    }

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable("id") Integer id) {
        return this.plantRepository.findById(id);
    }

    @PostMapping("/plants")
    @ResponseStatus(HttpStatus.CREATED)
    public Plant createPlant(@RequestBody Plant plant) {
        Plant newPlant = this.plantRepository.save(plant);
        return newPlant;
    }

    @PutMapping("/plants/{id}")
    public Plant updatePlant(@PathVariable("id") Integer id, @RequestBody Plant p) {
        Optional<Plant> plantToUpdateOptional = this.plantRepository.findById(id);
        if(!plantToUpdateOptional.isPresent()){
            return null;
        }

        // Since isPresent() was true, we can .get() the Plant object out of the Optional
        Plant plantToUpdate = plantToUpdateOptional.get();
        if(p.getName() != null){
            plantToUpdate.setName(p.getName());
        }
        if(p.getQuantity() != null){
            plantToUpdate.setQuantity(p.getQuantity());
        }
        if(p.getWateringFrequency() != null){
            plantToUpdate.setWateringFrequency(p.getWateringFrequency());
        }
        if(p.getHasFruit() != null){
            plantToUpdate.setHasFruit(p.getHasFruit());
        }
        Plant updatedPlant = this.plantRepository.save(plantToUpdate);
        return updatedPlant;
    }

    @DeleteMapping("plants/{id}")
    public Plant deletePlant(@PathVariable("id") Integer id) {
        Optional<Plant> plantToDeleteOptional = this.plantRepository.findById(id);
        if(!plantToDeleteOptional.isPresent()){
            return null;
        }

        // Since it was true
        Plant plantToDelete = plantToDeleteOptional.get();
        this.plantRepository.delete(plantToDelete);
        return plantToDelete;
    }

}