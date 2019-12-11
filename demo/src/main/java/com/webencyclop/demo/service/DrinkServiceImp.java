package com.webencyclop.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.webencyclop.demo.model.Drink;
import com.webencyclop.demo.repository.DrinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImp implements DrinkService {

    @Autowired
    DrinkRepository drinkRepository;
    @Autowired
    DrinkRepository repository;

    @Override
    public void saveDrink(Drink drink) {
        drinkRepository.save(drink);

    }

    @Override
    public Iterable<Drink> getAllDrink() {
        return repository.findAll();
    }

    @Override
    public boolean isDrinkAlreadyPresent(Drink drink) {
        return false;
    }

    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink findById(int iddrink) {
        return drinkRepository.findById(iddrink).orElseThrow(()-> new EntityNotFoundException());
    }


}