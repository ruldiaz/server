package com.webshop.server.products.controllers;

import com.webshop.server.products.entities.Product;
import com.webshop.server.products.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        try {
            Iterable<Product> products = this.productRepository.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving products");
        }
    }

    @GetMapping("/search")
    public List<Product> searchProductIsNew(
            @RequestParam(name="productIsNew", required=false)
            Boolean productIsNew){
        if(productIsNew != null){
            return this.productRepository.findByProductIsNewTrue();
        }else{
            return new ArrayList<>();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        Product newProduct = this.productRepository.save(product);
        return newProduct;
    }

}
