package com.example.eventmanagement.service;

import com.example.eventmanagement.repository.EventRepository;
import com.example.eventmanagement.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Holt alle Events aus der Datenbank
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Speichert ein Event in der Datenbank
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }


    public String checkConnection() {
        try {
            long count = eventRepository.count();
            return "Connected! Total events: " + count;
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }




}
