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

import com.skcet.LiveBeats.Model.Event;
import com.skcet.LiveBeats.Service.EventService;


@RestController
@RequestMapping("api/v1/event")
public class EventController {
	     
	@Autowired
	     private EventService eventService;
	     
	     @GetMapping("/getEvent")
	     public ResponseEntity<List<Event>>getEvent(){
	    	 return ResponseEntity.status(200).body(eventService.getEvent());
	     }
	     
	     @GetMapping("/getAllEvent")
	       	public ResponseEntity<Page<Event>> getAllEvent(
	       				@RequestParam(defaultValue = "0") int page, 
	       				@RequestParam(defaultValue = "10") int size,
	       				@RequestParam(defaultValue = "eventId") String sortField,
	       				@RequestParam(defaultValue = "asc") String sortOrder
	       			){
	       		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
	       		return ResponseEntity.status(200).body(eventService.getAllEvent(pageRequest));
	       	}

	     @PostMapping("/addEvent")
	     public ResponseEntity<String> addEvent(@RequestBody Event event){
	    	 boolean dataSaved=eventService.addEvent(event);
	    	 if(dataSaved) {
	    		 return ResponseEntity.status(200).body("event added successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("not added");
	    	 }
	     }
	     @PutMapping("/updateEvent/{eventId}")
	     public ResponseEntity<String>updateEvent(@PathVariable Long eventId,@RequestBody Event event){
	    	 boolean userData=eventService.updateEvent(eventId, event);
	    	 if(userData) {
	    		 return ResponseEntity.status(200).body("User updated successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("No record found to be updated");
	    	 }
	     }
	     @DeleteMapping("/deleteEvent")
	 	public ResponseEntity<String> deleteEvent(@RequestParam Long eventId){
	 		boolean userDeleted =eventService.deleteEvent(eventId);
	 		if(userDeleted) { 
	 			return ResponseEntity.status(200).body("User deleted successfully");
	 		} else {
	 			return ResponseEntity.status(404).body("No record found to be updated");
	 		}
	 	}
}
