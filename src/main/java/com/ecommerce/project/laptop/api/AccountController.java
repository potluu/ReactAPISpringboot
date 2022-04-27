package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.AccountDto;
import com.ecommerce.project.laptop.entitty.*;
import com.ecommerce.project.laptop.services.AccountServiceImpl;
import com.ecommerce.project.laptop.utils.TimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;
    private final PasswordEncoder passwordEncoder;
    /*

     */
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        List<Account> accounts = accountService.getAll();
        if (!accounts.isEmpty()) {
            List<AccountDto> accountDtoList = new ArrayList<>();
            accounts.forEach(account -> accountDtoList.add(new AccountDto(account)));
            return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/manages")
    public ResponseEntity<?> getAllAdministrator() {
        List<Administrator> admins = accountService.getAllAdmin();
        if (!admins.isEmpty()) {
            List<AccountDto> accountDtoList = new ArrayList<>();
            admins.forEach(admin -> accountDtoList.add(new AccountDto(admin.getAccount())));
            return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data ");
        }
    }

    /*

     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserByIy(@PathVariable("id") long id) {
        if (accountService.exitsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new AccountDto(accountService.getUserById(id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data");
    }

    /*

     */
    @GetMapping("/manage/{id}")
    public ResponseEntity<?> getAdministratorByIy(@PathVariable("id") long id) {
        if (accountService.exitsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new AccountDto(accountService.getAdministratorById(id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found data");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountByIy(@PathVariable("id") long id) {
        if (accountService.deteleAccountById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }

    }

    @PostMapping(value = "/account", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> saveAccount(@RequestParam("username") String userName, @RequestParam("password") String password
            , @RequestParam("typeaccount") String typeAccount) {
        if (userName != null && password != null && typeAccount != null) {
            List<Role> roles = new ArrayList<>();
            Account account = Account.builder()
                    .email(userName)
                    .password(passwordEncoder.encode(password))
                    .build();
            if (typeAccount.equals("USER")) {
                Role role = new Role(1, "ROLE_USER", null);
                roles.add(role);
                account.setRoles(roles);
                account.setUser(new User());
            } else if (typeAccount.equals("ADMIN")) {
                Role role = new Role(1, "ROLE_ADMIN", null);
                Role roleManaga = new Role(1, "ROLE_MANAGA", null);
                roles.add(role);
                roles.add(roleManaga);
                account.setRoles(roles);
                account.setAdministrator(new Administrator());
            }
            accountService.saveUser(account);
            return ResponseEntity.status(HttpStatus.OK).body("success");

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invaild url");
        }

    }

    /*

     */
    @PutMapping(value = "/account", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> updateAccount(@ModelAttribute("account") AccountDto accountDto) {
        if (accountService.exitsById(accountDto.getId())) {
            Information information = Information.builder()
                    .name(accountDto.getName())
                    .address(accountDto.getAddress())
                    .company(accountDto.getCompany())
                    .phone(accountDto.getPhone())
                    .sex(accountDto.getSex())
                    .dateBrithday(accountDto.getDateBrithday())
                    .createdDate(TimeUtils.getTimeNowSystem())
                    .build();
            Account account = Account.builder()
                    .email(accountDto.getEmail())
                    .password(passwordEncoder.encode(accountDto.getPassword()))
                    .activated(true)
                    .information(information)
                    .build();
            accountService.saveUser(account);
            return ResponseEntity.status(HttpStatus.OK).body("success");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invaild url");

    }
}
