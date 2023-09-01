package com.skcet.LiveBeats.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.skcet.LiveBeats.Model.Review;

import com.skcet.LiveBeats.Service.ReviewService;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
	     
	@Autowired
	     private ReviewService reviewService;
	     
	     @GetMapping("/getReview")
	     public ResponseEntity<List<Review>>getReview(){
	    	 return ResponseEntity.status(200).body(reviewService.getReview());
	     }
	     
	     @GetMapping("/getAllReview")
	       	public ResponseEntity<Page<Review>> getAllReview(
	       				@RequestParam(defaultValue = "0") int page, 
	       				@RequestParam(defaultValue = "10") int size,
	       				@RequestParam(defaultValue = "id") String sortField,
	       				@RequestParam(defaultValue = "asc") String sortOrder
	       			){
	       		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
	       		return ResponseEntity.status(200).body(reviewService.getAllReview(pageRequest));
	       	}

	     @PostMapping("/addReview")
	     public ResponseEntity<String> addReview(@RequestBody Review review){
	    	 boolean dataSaved=reviewService.addReview(review);
	    	 if(dataSaved) {
	    		 return ResponseEntity.status(200).body(" added successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("not added");
	    	 }
	     }
	     @PutMapping("/updateReview/{id}")
	     public ResponseEntity<String>updateReview(@PathVariable Long id,@RequestBody Review review){
	    	 boolean userData=reviewService.updateReview(id, review);
	    	 if(userData) {
	    		 return ResponseEntity.status(200).body(" updated successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("No record found to be updated");
	    	 }
	     }
	     @DeleteMapping("/deleteReview")
	 	public ResponseEntity<String> deleteReview(@RequestParam Long id){
	 		boolean userDeleted =reviewService.deleteReview(id);
	 		if(userDeleted) { 
	 			return ResponseEntity.status(200).body(" deleted successfully");
	 		} else {
	 			return ResponseEntity.status(404).body("No record found to be updated");
	 		}
	 	}
}
