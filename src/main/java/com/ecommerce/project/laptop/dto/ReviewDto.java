package com.ecommerce.project.laptop.dto;

import com.ecommerce.project.laptop.entitty.Review;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {

    private long id;

    private boolean confirm;
    private int rating;

    private String title;
    private String comment;

    private Date time;

    private String nameProduct;

    private long productId;

    private String nameUser;

    private long userId;

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.confirm = review.isConfirm();
        this.rating = review.getRating();
        this.title = review.getTitle();
        this.comment = review.getComment();
        this.time = review.getTime();
        this.productId = review.getProduct().getId();
        this.nameProduct = review.getProduct().getName();
        this.nameUser = review.getUser().getAccount().getEmail();
    }
}
