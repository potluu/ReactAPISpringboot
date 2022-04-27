package com.ecommerce.project.laptop.api;

import com.ecommerce.project.laptop.dto.BrandDto;
import com.ecommerce.project.laptop.dto.ReviewDto;
import com.ecommerce.project.laptop.entitty.Brand;
import com.ecommerce.project.laptop.entitty.Review;
import com.ecommerce.project.laptop.services.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {
    private ReviewServiceImpl reviewService;

    /*

     */
    @GetMapping(value = "/reviews")
    public ResponseEntity<List<ReviewDto>> getAll() {
        List<ReviewDto> listReviewDtos = new ArrayList<>();
        reviewService.getAllReview().forEach(review ->
                listReviewDtos.add(new ReviewDto(review)));
        return new ResponseEntity<>(listReviewDtos, HttpStatus.OK);
    }

    /*

     */
    @GetMapping(value = "/review/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") int id) {
        ReviewDto reviewDto = new ReviewDto(reviewService.getById(id));
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }
    /*

     */

    @DeleteMapping("/review")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        if (reviewService.deleteById(id)) {
            reviewService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }
    }

}
