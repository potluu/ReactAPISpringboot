package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerReponsitory  extends JpaRepository<Banner,Long> {

}
