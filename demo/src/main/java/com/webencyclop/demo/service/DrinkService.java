package com.webencyclop.demo.service;

import com.webencyclop.demo.model.Drink;


public interface DrinkService{

    public void saveDrink(Drink drink);

    public Iterable<Drink> getAllDrink();

    public boolean isDrinkAlreadyPresent(Drink drink);

    //Apis de bebidas

    public java.util.List<Drink>findAll();
    
    public Drink findById(int iddrink);
}