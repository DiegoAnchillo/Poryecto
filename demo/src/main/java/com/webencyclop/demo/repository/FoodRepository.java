package com.webencyclop.demo.repository;

import com.webencyclop.demo.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer>{
    
}
