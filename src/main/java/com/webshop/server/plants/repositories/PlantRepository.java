package com.webshop.server.plants.repositories;
import org.springframework.data.repository.CrudRepository;
import com.webshop.server.plants.entities.Plant;

public interface PlantRepository extends CrudRepository<Plant, Integer> {

}