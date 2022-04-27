package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.component.Excel;
import com.ecommerce.project.laptop.entitty.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
public class AccountDto extends Excel {
    private long id;
    private String email;
    private Long inforId;
    private String name;
    private Date createdDate;
    private String phone;
    private Date dateBrithday;
    private String sex;
    private String typeAccount;
    private String company;
    private String password;
    private String address;
    private String position;
    private long userId;
    private long adminId;
    public AccountDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.inforId = account.getInformation().getId();
        this.name = account.getInformation().getName();
        this.createdDate = account.getInformation().getCreatedDate();
        this.phone = account.getInformation().getPhone();
        this.dateBrithday = account.getInformation().getDateBrithday();
        this.sex = account.getInformation().getSex();
        this.company = account.getInformation().getCompany();
        this.address = account.getInformation().getAddress();
        this.userId = account.getUser().getId();
        this.adminId = account.getAdministrator().getId();
        this.position = account.getAdministrator().getPosition().name();
    }

    @Override
    public void writeData(Row cells) {

    }
}
