package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Order;
import com.ecommerce.project.laptop.reponsitory.OrderReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService {
    private final OrderReponsitory orderReponsitory;


    @Override
    public List<Order> getALlOrder() {
        return orderReponsitory.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderReponsitory.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        if(orderReponsitory.existsById(id)){
            return true;
        }else{
        return false;}
    }

    @Override
    public Order saveOrder(Order order) {
        return orderReponsitory.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderReponsitory.save(order);
    }

    @Override
    public boolean existsById(long id) {
        if(orderReponsitory.existsById(id)){
            return true;
        }
        return false;
    }
}
