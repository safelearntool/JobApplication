package com.fspring.JobApplication.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long CompanyId);
    boolean addReview (Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
    boolean deleteReview(Long companyId, Long reviewId);
}
