package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReponsitory extends JpaRepository<Order,Long> {
}
