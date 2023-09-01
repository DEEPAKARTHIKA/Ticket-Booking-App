package com.skcet.LiveBeats.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skcet.LiveBeats.Model.Event;


public interface EventRepository extends JpaRepository<Event, Integer>{
    
	boolean existsByEventName(String eventName);
	Optional<Event> findByEventId(Long eventId);
	void deleteByEventId(Long eventId);
	
}  
