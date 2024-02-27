package com.webshop.server.products.repositories;

import com.webshop.server.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByProductIsNewTrue();
}
