package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category,Integer> {
}
