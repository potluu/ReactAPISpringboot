package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingReponsirory extends JpaRepository<ShoppingCart,Long> {
}
