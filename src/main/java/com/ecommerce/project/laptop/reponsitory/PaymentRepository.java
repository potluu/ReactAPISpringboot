package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
