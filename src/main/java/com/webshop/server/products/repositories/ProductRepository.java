package com.webshop.server.products.repositories;
import org.springframework.data.repository.CrudRepository;
import com.webshop.server.products.entities.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

}
