package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewReponsitory extends JpaRepository<Review,Long> {
}
