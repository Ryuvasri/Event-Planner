package com.event.eventplan.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class EventModel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    private String eventName;
    private String place;
    private LocalDate date;
    private LocalTime time;

    public EventModel()
    {

    }

    public EventModel(String eventName, String place, LocalDate data, LocalTime time)
    {
        this.eventName = eventName;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public String getEventName()
    {
        return eventName;
    }
    public String getPlace()
    {
        return place;
    }
    public LocalDate getDate()
    {
        return date;
    }
    public LocalTime getTime()
    {
        return time;
    }

     public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }
    public void setPlace(String place)
    {
        this.place = place;
    }
    public void setDate(LocalDate data)
    {
        this.date = date;
    }
    public void setTime(LocalTime time)
    {
        this.time = time;
    }
    
}
