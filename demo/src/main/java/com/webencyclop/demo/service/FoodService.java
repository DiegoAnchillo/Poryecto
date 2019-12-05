package com.webencyclop.demo.service;

import com.webencyclop.demo.model.Food;

import java.util.List;

public interface FoodService{

    public void saveFood(Food food);

    public Iterable<Food> getAllFood();

    public boolean isFoodAlreadyPresent(Food food);
    
    //apis de comida

    public List<Food>findAll();
    
    public Food findById(int id);
}