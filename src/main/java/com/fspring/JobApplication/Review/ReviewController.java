package com.fspring.JobApplication.Review;

import com.fspring.JobApplication.Company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{reviews}")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviews(@PathVariable Long companyId,
                                             @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewSave = reviewService.addReview(companyId, review);
        if(isReviewSave){
            return new ResponseEntity<>("Review Posted", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Review Not Posted", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review updatedrReview){

        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, updatedrReview );
        if(isReviewUpdated){
            return new ResponseEntity<>("Review has been Updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){

        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("Review Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
        }
    }

}
