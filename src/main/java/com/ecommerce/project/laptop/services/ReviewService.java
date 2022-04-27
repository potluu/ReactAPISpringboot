package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview();

    Review getById(long id);

    boolean deleteById(long id);

    Review saveReview(Review category);

}
