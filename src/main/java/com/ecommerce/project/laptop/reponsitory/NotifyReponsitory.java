package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Notify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifyReponsitory extends JpaRepository<Notify,Long> {
}
