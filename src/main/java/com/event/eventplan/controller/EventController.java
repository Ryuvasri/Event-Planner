package com.event.eventplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;
import com.event.eventplan.model.EventModel;
import com.event.eventplan.service.EventService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/events")
public class EventController 
{
    @Autowired
    public EventService eservice;

    @PostMapping("/add")
    public EventModel addEvent(@RequestBody EventModel event) {
        return eservice.addEvent(
            event.getEventName(),
            event.getPlace(),
            event.getDate(),
            event.getTime()
        );
    }
    

    @GetMapping("/all")
    public List<EventModel> getAll() {
        return eservice.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        eservice.deleteEvent(id);
        return "Deleted event with id: " + id;
    }

    @PutMapping("/{id}")
   public String update(@PathVariable Long id, @RequestBody EventModel event) {
    eservice.updateEvent(
        id,
        event.getEventName(),
        event.getPlace(),
        event.getDate(),
        event.getTime()
    );
    return "Updated event with id: " + id;
}
    

}
