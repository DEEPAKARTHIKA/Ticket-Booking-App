package com.skcet.LiveBeats.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.skcet.LiveBeats.Model.User;

import com.skcet.LiveBeats.Service.UserService;


	@RestController
	@RequestMapping("api/v1/user")
	@CrossOrigin("*")
	public class UserController {
		
		private final static Logger logger=LoggerFactory.getLogger(User.class);
		     
		@Autowired
		     private UserService userService;
		     
		     @GetMapping("/getUser")
		     public ResponseEntity<List<User>>getUser(){
//		    	 System.out.println("SOP");
//		    	 logger.info("This is Tommy");
//		    	 logger.debug("debug");
//		    	 logger.warn("warn");
//		    	 logger.error("error");
		    	 return ResponseEntity.status(200).body(userService.getUser());
		     }
		     
		     @GetMapping("/getAllUser")
		       	public ResponseEntity<Page<User>> getAllUser(
		       				@RequestParam(defaultValue = "0") int page, 
		       				@RequestParam(defaultValue = "10") int size,
		       				@RequestParam(defaultValue = "userId") String sortField,
		       				@RequestParam(defaultValue = "asc") String sortOrder
		       			){
		       		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
		       		return ResponseEntity.status(200).body(userService.getAllUser(pageRequest));
		       	}

		     @PostMapping("/addUser")
		     public ResponseEntity<String> addUser(@RequestBody User user){
		    	 boolean dataSaved=userService.addUser(user);
		    	 if(dataSaved) {
		    		 return ResponseEntity.status(200).body("added successfully");
		    	 }
		    	 else {
		    		 return ResponseEntity.status(404).body("not added");
		    	 }
		     }
		     @PutMapping("/updateUser/{userId}")
		     public ResponseEntity<String>updateEvent(@PathVariable Long userId,@RequestBody User user){
		    	 boolean userData=userService.updateUser(userId, user);
		    	 if(userData) {
		    		 return ResponseEntity.status(200).body("User updated successfully");
		    	 }
		    	 else {
		    		 return ResponseEntity.status(404).body("No record found to be updated");
		    	 }
		     }
		     @DeleteMapping("/deleteUser")
		 	public ResponseEntity<String> deleteUser(@RequestParam Long userId){
		 		boolean userDeleted =userService.deleteUser(userId);
		 		if(userDeleted) { 
		 			return ResponseEntity.status(200).body("User deleted successfully");
		 		} else {
		 			return ResponseEntity.status(404).body("No record found to be updated");
		 		}
		 	}
		     
		     @GetMapping("/getUserQuery")
		     public ResponseEntity<List<User>>getUserQuery(){
		    	 return ResponseEntity.status(200).body(userService.getQuery());
		     }
	}


