package com.example.eventmanagement.controller;

import com.example.eventmanagement.entities.Event;
import com.example.eventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    // Methode, um eine Liste aller Events zurückzugeben
    @GetMapping("/entities")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }
}
