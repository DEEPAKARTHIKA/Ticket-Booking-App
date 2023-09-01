package com.skcet.LiveBeats.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Venue {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int venue_id;
     private String venue_name;
     private String venue_location;
     private String venue_seatings;
     
	public int getVenue_id() {
		return venue_id;
	}
	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	public String getVenue_location() {
		return venue_location;
	}
	public void setVenue_location(String venue_location) {
		this.venue_location = venue_location;
	}
	public String getVenue_seatings() {
		return venue_seatings;
	}
	public void setVenue_seatings( String venue_seatings) {
		this.venue_seatings = venue_seatings;
	}
     
}
