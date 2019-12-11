package com.webencyclop.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="drink_table")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="drink_id")
    private int iddrink;

    @NotNull(message="Drink name is compulsory")
    @Column(name = "drink_name")
    private String namedrink;

    @NotNull(message = "Drink size is compulsory")
    @Column(name="drink_size")
    private String size;

    @NotNull(message = "Drink cost is compulsory")
    @Column(name="drink_cost")
    private String costdrink;
    
    //@NotNull(message = "Drink image is compulsory")
    //@Column(name="drink_image")
    //private String imagedrink;

    public int getIddrink() {
        return iddrink;
    }

    public void setIddrink(int iddrink) {
        this.iddrink = iddrink;
    }

    public String getNamedrink() {
        return namedrink;
    }

    public void setNamedrink(String namedrink) {
        this.namedrink = namedrink;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCostdrink() {
        return costdrink;
    }

    public void setCostdrink(String costdrink) {
        this.costdrink = costdrink;
    }

    //public String getImagedrink() {
    //    return imagedrink;
    //}

    //public void setImagedrink(String imagedrink) {
    //    this.imagedrink = imagedrink;
    //}
    

}
