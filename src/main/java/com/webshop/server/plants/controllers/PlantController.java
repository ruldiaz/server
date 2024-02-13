package com.webshop.server.plants.controllers;
import org.springframework.http.ResponseEntity;

import com.webshop.server.plants.entities.Plant;
import com.webshop.server.plants.repositories.PlantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/plants")
    @ResponseStatus(HttpStatus.CREATED)
    public Plant createPlant(@RequestBody Plant plant) {
        return this.plantRepository.save(plant);
    }

}