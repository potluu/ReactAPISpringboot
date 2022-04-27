package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.AccountDto;
import com.ecommerce.project.laptop.dto.ShoppingCartDto;
import com.ecommerce.project.laptop.entitty.Account;
import com.ecommerce.project.laptop.entitty.ShoppingCart;
import com.ecommerce.project.laptop.entitty.User;
import com.ecommerce.project.laptop.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    /*

     */

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        List<Account> accounts=accountService.getAll();
        if(!accounts.isEmpty()){
            List<AccountDto> accountDtoList=new ArrayList<>();
            accounts.forEach(account -> accountDtoList.add(new AccountDto(account)));
            return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/manages")
    public ResponseEntity<?> getAllAdministrator() {
        List<Account> accounts=accountService.getAllUser();
        if(!accounts.isEmpty()){
            List<AccountDto> accountDtoList=new ArrayList<>();
            accounts.forEach(account -> accountDtoList.add(new AccountDto(account)));
            return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserByIy(@PathVariable("id") long id) {
        Account account = accountService.getAccountById(id);
        AccountDto accountDto = null;
        if (account != null) {
            accountDto = new AccountDto(account);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountDto);
    }


    /*

     */
    @GetMapping("/manage/{id}")
    public ResponseEntity<?> getAdministratorByIy(@PathVariable("id") long id) {
        Account account = accountService.getAccountById(id);
        AccountDto accountDto = null;
        if (account != null) {
            accountDto = new AccountDto(account);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountByIy(@PathVariable("id") long id) {
        if (accountService.deteleAccountById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);

        }

    }

    @PostMapping(value = "/acc", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> saveAccount(@PathVariable("key") String key, @ModelAttribute("account") Account account) {

        return null;

    }

    /*

     */
    @PutMapping(value = "/acc", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> updateAccount(@PathVariable("key") String key, @ModelAttribute("account") Account account) {

        return null;
    }

    @PostMapping("/accr")
    public  ResponseEntity<?> resetPassword(@PathVariable("id") long id){
        if(accountService.exitsById(id)){

        }else {

        }
        return null;
    }

}
