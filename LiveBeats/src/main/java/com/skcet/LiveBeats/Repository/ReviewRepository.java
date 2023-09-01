package com.skcet.LiveBeats.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.LiveBeats.Model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	
	    
		boolean existsById(Long id);
		Optional<Review> findById(Long id);
		void deleteById(Long id);
		
	
}
