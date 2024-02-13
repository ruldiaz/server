package com.webshop.server.plants.controllers;

import com.webshop.server.plants.entities.Plant;
import com.webshop.server.plants.repositories.PlantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/customers")
public class PlantController {
    private final PlantRepository plantRepository;

    public PlantController(final PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
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