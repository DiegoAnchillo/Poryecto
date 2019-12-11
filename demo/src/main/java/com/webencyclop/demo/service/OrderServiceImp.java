package com.webencyclop.demo.service;

import com.webencyclop.demo.model.Order;
import com.webencyclop.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderRepository repository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrder() {
        return repository.findAll();
    }

    @Override
    public boolean isOrderAlreadyPresent(Order order) {
        return false;
    }

}