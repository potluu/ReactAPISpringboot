package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Administrator;
import com.ecommerce.project.laptop.entitty.Notify;
import com.ecommerce.project.laptop.entitty.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@AllArgsConstructor
@Data
public class NotifyDto {

    private long id;

    private String content;

    private boolean checks;


    private Date time;


    private String keyword;

    private String sendName;

    private  int numberUserSend;

    public NotifyDto(Notify notify) {
        this.id = notify.getId();
        this.content = notify.getContent();
        this.checks = notify.isChecks();
        this.time = notify.getTime();
        this.keyword = notify.getKeyword();
        this.sendName = notify.getAdministrator().getAccount().getEmail();
        this.numberUserSend = notify.getUsers().size();
    }
}
