package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product,Long> {
}
