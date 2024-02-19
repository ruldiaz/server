package com.webshop.server.products.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="IMAGES")
    private ArrayList<String> images;

    public ArrayList<String> getImages() {
        return this.images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    @Column(name="BRAND")
    private String brand;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name="CATEGORY")
    private String category;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name="REVIEWS")
    private ArrayList<String> reviews;

    public ArrayList<String> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    @Column(name="RATING")
    private Double rating;

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Column(name="NUMBEROFREVIEWS")
    private Double numberOfReviews;

    public Double getNumberOfReviews() {
        return this.numberOfReviews;
    }

    public void setNumberOfReviews(Double numberOfReviews){
        this.numberOfReviews = numberOfReviews;
    }

    @Column(name="PRICE")
    private Double price;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name="STOCK")
    private Double stock;

    public Double getStock() {
        return this.stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    @Column(name="PRODUCTISNEW")
    private Boolean productIsNew;

    public Boolean getProductIsNew() {
        return this.productIsNew;
    }

    public void setProductIsNew(Boolean productIsNew) {
        this.productIsNew = productIsNew;
    }

    @Column(name="STRIPEID")
    private String stripeId;

    public String getStripeId() {
        return this.stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }
}
