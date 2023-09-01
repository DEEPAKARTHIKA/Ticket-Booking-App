package com.skcet.LiveBeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skcet.LiveBeats.Model.Event;
import com.skcet.LiveBeats.Repository.EventRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional  
public class EventServiceImpl implements EventService{
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public boolean addEvent(Event event) {
		boolean eventExists=eventRepository.existsByEventName(event.getEventName());
		if(!eventExists) {
			eventRepository.save(event);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public List<Event> getEvent(){
		return eventRepository.findAll();
	}
	
	@Override
	public boolean updateEvent(Long eventId,Event event) {
		Optional<Event>existingOptional=eventRepository.findByEventId(eventId);
		if(existingOptional.isPresent()) {
		Event userExists=existingOptional.get()	;
		userExists.setEventName(event.getEventName());
		userExists.setDateTime(event.getDateTime());
		userExists.setDescription(event.getDescription());
		userExists.setTicketPrice(event.getTicketPrice());
		userExists.setTicketQuantity(event.getTicketQuantity());
		eventRepository.save(userExists);
				return true;
		}
	else {
		return false;
	}                       
	}
	@Override
	public boolean deleteEvent(Long eventId) {
		  
		Optional<Event> existingUserOptional = eventRepository.findByEventId(eventId);
		if(existingUserOptional.isPresent()) {
			eventRepository.deleteByEventId(eventId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Page<Event> getAllEvent(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
