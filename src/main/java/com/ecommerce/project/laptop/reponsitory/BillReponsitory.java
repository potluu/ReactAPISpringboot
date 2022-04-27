package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillReponsitory extends JpaRepository<Bill,Long> {
}
