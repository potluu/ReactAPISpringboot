package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Transpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportReponsitory extends JpaRepository<Transpost,Long> {
}
