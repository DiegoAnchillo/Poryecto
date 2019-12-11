package com.webencyclop.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.webencyclop.demo.model.Food;
import com.webencyclop.demo.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired
	FoodRepository foodRepository;
	@Autowired
	FoodRepository repository;

    @Override
    public Iterable<Food> getAllFood() {
        return repository.findAll();
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(int idfood) {
        return foodRepository.findById(idfood).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public boolean isFoodAlreadyPresent(Food food) {
        return false;
    }

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);

    }

}