package com.greatlearning.great_kart.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "title")
    private String name;
    private String price;

    public Product() {

    }

    public Product(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}
