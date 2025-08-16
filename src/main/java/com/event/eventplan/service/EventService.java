package com.event.eventplan.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.event.eventplan.model.EventModel;
import com.event.eventplan.repository.EventRepository;

@Service
public class EventService 
{
    @Autowired
    public EventRepository erep ;

    public EventModel addEvent(String eventName, String place, LocalDate date, LocalTime time)
    {
        EventModel event = new EventModel(eventName, place, date, time);
        return erep.save(event);
    }
    public List<EventModel> getAllEvents()
    {
        return erep.findAll();
    }
    public void deleteEvent(long id)
    {
        erep.deleteById(id);
    }
    public void updateEvent(Long id, String eventName, String place, LocalDate date, LocalTime time)
    {
        EventModel event = erep.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        event.setEventName(eventName);
        event.setPlace(place);
        event.setDate(date);
        event.setTime(time);

    erep.save(event);
    }
}
