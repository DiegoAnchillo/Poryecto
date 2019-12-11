package com.webencyclop.demo.repository;

import com.webencyclop.demo.model.Drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Integer>{
    
}
