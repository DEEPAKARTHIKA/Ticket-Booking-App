package com.skcet.LiveBeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.skcet.LiveBeats.Model.Review;
import com.skcet.LiveBeats.Repository.ReviewRepository;

import jakarta.transaction.Transactional;


	@Service
	@Transactional  
	public class ReviewServiceImpl implements ReviewService{
		@Autowired
		private ReviewRepository reviewRepository;
		
		@Override
		public boolean addReview(Review review) {
			boolean eventExists=reviewRepository.existsById(review.getId());
			if(!eventExists) {
				reviewRepository.save(review);
				return true;
			}
			else {
				return false;
			}
		}
		
		@Override
		public List<Review> getReview(){
			return reviewRepository.findAll();
		}
		
		@Override
		public boolean updateReview(Long id,Review review) {
			Optional<Review>existingOptional=reviewRepository.findById(id);
			if(existingOptional.isPresent()) {
			Review userExists=existingOptional.get()	;
			userExists.setRatings(review.getRatings());
			userExists.setComments(review.getComments());;
			
			reviewRepository.save(userExists);
					return true;
			}
		else {
			return false;
		}                       
		}
		@Override
		public boolean deleteReview(Long id) {
			  
			Optional<Review> existingUserOptional = reviewRepository.findById(id);
			if(existingUserOptional.isPresent()) {
				reviewRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Page<Review> getAllReview(PageRequest pageRequest) {
			// TODO Auto-generated method stub
			return reviewRepository.findAll(pageRequest);
		}
	}


