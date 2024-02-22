package com.example.reviewservice.controller;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewRepository reviewRepository;

  @GetMapping
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @PostMapping
  public Review addReview(@RequestBody Review review) {
    return reviewRepository.save(review);
  }

  @DeleteMapping("/{id}")
  public void deleteReview(@PathVariable Long id) {
    reviewRepository.deleteById(id);
  }
}
