package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Administrator;
import com.ecommerce.project.laptop.entitty.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {
    List<Account> getAll();

    List<User> getAllUser();

    List<Administrator> getAllAdmin();

    Account getAccountById(long id);

    Account getUserById(long id);

    Account getAdministratorById(long id);

    boolean deteleAccountById(long id);

    Account saveUser(Account account);

    Account saveAdministrator(Account account);

    Account updateUser(Account account);

    Account updateAdministrator(Account account);

    boolean exitsById(long id);

}
