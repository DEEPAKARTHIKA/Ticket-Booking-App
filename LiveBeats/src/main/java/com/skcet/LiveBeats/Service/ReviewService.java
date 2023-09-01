package com.skcet.LiveBeats.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import com.skcet.LiveBeats.Model.Review;

public interface ReviewService{

	
    
   
	boolean addReview(Review review);

	List<Review> getReview();
	boolean updateReview(Long id, Review review);
	boolean deleteReview(Long id);

	Page<Review> getAllReview(PageRequest pageRequest);
	
	
}
