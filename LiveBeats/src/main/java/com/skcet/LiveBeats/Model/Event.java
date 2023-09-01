package com.skcet.LiveBeats.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	private String eventName;
	private String dateTime;
	private String description;
	private long ticketPrice;
	private int ticketQuantity;

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "reviewId",referencedColumnName = "eventId")
	private List<Review>review;
	
	public int getEventId() {
		return eventId;
	}       
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketQuantity() {
		return ticketQuantity;
	}
	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}
	public Event(int eventId, String eventName, int venueId, String dateTime, String description, long ticketPrice,
			int ticketQuantity) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.dateTime = dateTime;
		this.description = description;
		this.ticketPrice = ticketPrice;
		this.ticketQuantity = ticketQuantity;
	}
	public Event() {
		super();
	}
//	public Venue getVenue() {
//		return venue;
//	}
//	public void setVenue(Venue venue) {
//		this.venue = venue;
//	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	
}
