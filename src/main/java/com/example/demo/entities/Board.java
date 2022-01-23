package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CAPACITY")
    private String capacity;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne  (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false )
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
