package com.example.eventmanagement.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Embeddable;

@Embeddable
public class DateTime {

    private LocalDate date;
    private LocalTime time;

    // Constructors, Getters, and Setters
    public DateTime() {}

    public DateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
