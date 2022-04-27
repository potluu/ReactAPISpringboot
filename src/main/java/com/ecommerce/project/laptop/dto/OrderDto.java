package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Order;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private long id;
    private  String sku;
    private String note;
    private String status;
    private Date createDate;
    private long transpostId;
    private String nameUser;
    private long userId;
    private int amoount;
    private float total;
    public OrderDto(Order order) {
        this.id = order.getId();
        this.sku = order.getSku_order();
        this.note = order.getNote();
        this.status = order.getNote();
        this.createDate = order.getCreatedDate();
        this.transpostId = order.getTranspost().getId();
        this.nameUser = order.getUser().getName();
        this.userId = order.getUser().getId();
        this.amoount = order.getOrderDetails().getAmount();
        this.total = order.getOrderDetails().getTotal();
    }
}
