package com.ecommerce.project.laptop.reponsitory;

import com.ecommerce.project.laptop.entitty.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountReponsitory  extends JpaRepository<Account,Long> {
    Account findByEmail(String email);

}
