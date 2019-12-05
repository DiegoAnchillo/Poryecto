package com.webencyclop.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="food_table")
public class Food{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="food_id")
    private int id;

    @NotNull(message="Food name is compulsory")
    @Column(name = "food_name")
    private String namefood;

    @NotNull(message = "Food cost is compulsory")
    @Column(name="food_cost")
    private String cost;

    @NotNull(message = "Food descripcion is compulsory")
    @Column(name="food_descripcion")
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamefood() {
        return namefood;
    }

    public void setNamefood(String namefood) {
        this.namefood = namefood;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    


    
}