package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.Administrator;
import com.ecommerce.project.laptop.entitty.User;
import com.ecommerce.project.laptop.reponsitory.AccountReponsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountReponsitory accountRep;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account= accountRep.findByEmail(username);
        if(account==null){
            throw new UsernameNotFoundException("user not found");
        }else {
            log.info("user name"+account.getEmail());
        }
        Set<SimpleGrantedAuthority> authoritySet= new HashSet<SimpleGrantedAuthority>();
        account.getRoles().forEach(role->
            authoritySet.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(account.getEmail(),account.getPassword(),authoritySet);
    }

    @Override
    public List<Account> getAll() {
        return accountRep.findAll();
    }

    @Override
    public List<User> getAllUser() {
        List<User> listUser =new ArrayList<>();
        accountRep.findAll().forEach(account -> listUser.add(account.getUser()));
        return listUser;
    }

    @Override
    public List<Administrator> getAllAdmin() {
        List<Administrator> administratorList= new ArrayList<>();
        accountRep.findAll().forEach(account -> administratorList.add(account.getAdministrator()));
        return administratorList;
    }

    @Override
    public Account getAccountById(long id) {
        return accountRep.findById(id).orElse(null);
    }

    @Override
    public Account getUserById(long id) {
            Account acc = null;
            List<Account> listUser=null;
            for(Account account:listUser) {
                if (account.getUser().getId() == id) {
                    acc = account;
                    break;
                }
            }
        return acc;
    }

    @Override
    public Account getAdministratorById(long id) {
        Account acc = null;
        List<Account> listUser=null;
        for(Account account:listUser) {
            if (account.getAdministrator().getId() == id) {
                acc = account;
                break;
            }
        }
        return acc;
    }

    @Override
    public boolean deteleAccountById(long id) {
        boolean check=false;
        if(accountRep.existsById(id)){
            accountRep.deleteById(id);
            check=true;
        }
        return  check;

    }

    @Override
    public Account saveUser(Account account) {

        return accountRep.save(account);
    }

    @Override
    public Account saveAdministrator(Account account) {
        return accountRep.save(account);
    }

    @Override
    public Account updateUser(Account account) {
        return accountRep.save(account);
    }

    @Override
    public Account updateAdministrator(Account account) {
        return accountRep.save(account);
    }

    @Override
    public boolean exitsById(long id) {
        boolean check=false;
        if(accountRep.existsById(id)){
            check=true;
        }
        return  check;
    }
}
