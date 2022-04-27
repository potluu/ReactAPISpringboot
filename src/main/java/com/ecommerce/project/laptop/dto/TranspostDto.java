package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Transpost;
import lombok.Data;

import java.util.Date;
@Data
public class TranspostDto {
    private long id;
    private String sku;
    private String status;
    private String nameShiper;
    private Date deliveredDate;
    private boolean checks;
    private String recever;
    private String email;
    private String phone;
    private String address;
    private String note;
    public TranspostDto(Transpost transpost) {
        this.id = transpost.getId();
        this.sku = transpost.getSkuMVC();
        this.status = transpost.getStatus().name();
        this.nameShiper = transpost.getNameShipper();
        this.deliveredDate = transpost.getDeliveredDate();
        this.checks = transpost.isChecks();
        this.recever = transpost.getRecever();
        this.email = transpost.getEmail();
        this.phone = transpost.getPhone();
        this.address = transpost.getAddress();
        this.note = transpost.getNote();
    }
}
