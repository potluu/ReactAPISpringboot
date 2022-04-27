package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Bill;
import lombok.Data;

import java.util.Date;
@Data
public class BillDto {
    private long id;
    private String sku;
    private String namePay;
    private Date createBillDate;
    private double totalPrice;
    private String nameUser;
    private long userId;
    private long paymentId;
    public BillDto(Bill bill) {
        this.id = bill.getId();
        this.sku = bill.getCodeBill();
        this.namePay = bill.getNamePay();
        this.createBillDate = bill.getPayDate();
        this.totalPrice = bill.getTotalPrice();
        this.nameUser = bill.getUser().getName();
        this.userId = bill.getUser().getId();
        this.paymentId = bill.getPayment().getId();
    }
}
