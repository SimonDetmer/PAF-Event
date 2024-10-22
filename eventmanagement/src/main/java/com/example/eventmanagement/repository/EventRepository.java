package com.example.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventmanagement.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long> {
    // Optional: Eigene Abfragemethoden definieren
}