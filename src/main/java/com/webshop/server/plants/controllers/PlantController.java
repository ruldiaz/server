package com.webshop.server.plants.controllers;

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

    @GetMapping("/error")
    public String getError() {
        return "Error";
    }
    @GetMapping("/plants")
    public Iterable<Plant> getAllPlants() {
        System.out.println("Hello");
        return this.plantRepository.findAll();
    }

    @PostMapping("/plants")
    @ResponseStatus(HttpStatus.CREATED)
    public Plant createPlant(@RequestBody Plant plant) {
        return this.plantRepository.save(plant);
    }

}