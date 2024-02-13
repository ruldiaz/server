package com.webshop.server.plants.entities;
        import jakarta.persistence.Entity;
        import jakarta.persistence.Table;
        import jakarta.persistence.Id;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.Column;

@Entity
@Table(name="PLANTS")
public class Plant {

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

    @Column(name="QUANTITY")
    private Integer quantity;

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name="WATERING_FREQUENCY")
    private Integer wateringFrequency;

    public Integer getWateringFrequency() {
        return this.wateringFrequency;
    }

    public void setWateringFrequency(Integer wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    @Column(name="HAS_FRUIT")
    private Boolean hasFruit;

    public Boolean getHasFruit() {
        return this.hasFruit;
    }

    public void setHasFruit(Boolean hasFruit) {
        this.hasFruit = hasFruit;

    }
}