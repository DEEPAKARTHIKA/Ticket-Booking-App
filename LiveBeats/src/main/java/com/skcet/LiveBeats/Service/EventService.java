package com.skcet.LiveBeats.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.skcet.LiveBeats.Model.Event;


public interface EventService {
    public boolean addEvent(Event event);
    public List<Event>getEvent();
    
    public boolean updateEvent(Long eventId, Event event);
    public boolean deleteEvent(Long eventId);
	public Page<Event> getAllEvent(PageRequest pageRequest);
}
