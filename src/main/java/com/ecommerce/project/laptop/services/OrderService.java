package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getALlOrder();

    public Order getOrderById(long id);

    public boolean deleteById(long id);

    public Order saveOrder(Order order);

    public Order updateOrder(Order order);


    boolean existsById(long id);
}
