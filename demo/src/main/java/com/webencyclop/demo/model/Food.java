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
    private int idfood;

    @NotNull(message="Food name is compulsory")
    @Column(name = "food_name")
    private String namefood;

    @NotNull(message = "Food cost is compulsory")
    @Column(name="food_cost")
    private String costfood;

    @NotNull(message = "Food descripcion is compulsory")
    @Column(name="food_descripcion")
    private String descripcion;

    //@NotNull(message = "Food image is compulsory")
    //@Column(name="food_image")
    //private String imagefood;

    public int getIdfood() {
        return idfood;
    }

    public void setIdfood(int idfood) {
        this.idfood = idfood;
    }

    public String getNamefood() {
        return namefood;
    }

    public void setNamefood(String namefood) {
        this.namefood = namefood;
    }

    public String getCostfood() {
        return costfood;
    }

    public void setCostfood(String costfood) {
        this.costfood = costfood;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //public String getImagefood() {
    //    return imagefood;
    //}

    //public void setImagefood(String imagefood) {
    //    this.imagefood = imagefood;
    //}

    
    
}