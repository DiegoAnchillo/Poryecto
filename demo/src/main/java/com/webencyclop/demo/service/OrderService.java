package com.webencyclop.demo.service;

import com.webencyclop.demo.model.Order;

public interface OrderService{

    public void saveOrder(Order order);

    public Iterable<Order> getAllOrder();

    public boolean isOrderAlreadyPresent(Order order);
}