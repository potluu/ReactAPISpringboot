package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Account;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.Date;

@RequiredArgsConstructor
@Data
public class UserDto {
    private long accountId;

    private String name;

    private Date createdDate;

    private String phone;

    private Date dateBrithday;

    private String sex;

    private String company;

    private String address;

    private String email;

    public UserDto(Account account) {
        this.accountId = account.getId();
        this.name = account.getInformation().getName();
        this.createdDate = account.getInformation().getCreatedDate();
        this.phone = account.getInformation().getPhone();
        this.dateBrithday = account.getInformation().getDateBrithday();
        this.sex = account.getInformation().getSex();
        this.company = account.getInformation().getCompany();
        this.address = account.getInformation().getAddress();
        this.email=account.getEmail();
    }
}
