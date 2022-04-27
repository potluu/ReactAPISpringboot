package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandReponsitory extends JpaRepository<Brand,Integer> {
}
