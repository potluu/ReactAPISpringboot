package com.ecommerce.project.laptop.services;

import com.ecommerce.project.laptop.entitty.Review;
import com.ecommerce.project.laptop.reponsitory.ReviewReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewReponsitory reviewReponsitory;
    @Override
    public List<Review> getAllReview() {
        return reviewReponsitory.findAll();
    }

    @Override
    public Review getById(long id) {
        return reviewReponsitory.findById(id).orElse(new Review());
    }

    @Override
    public boolean deleteById(long id) {
        if(reviewReponsitory.existsById(id)){
            reviewReponsitory.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Review saveReview(Review review) {
        return null;
    }
}
