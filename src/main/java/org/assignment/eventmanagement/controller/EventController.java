package org.assignment.eventmanagement.controller;

import org.assignment.eventmanagement.Model.Event;
import org.assignment.eventmanagement.Model.Event2;
import org.assignment.eventmanagement.repo.EventRepo;
import org.assignment.eventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    EventRepo e;

    @GetMapping("/events/find")
    List<Event2> getEvent(
            @RequestParam  double Latitude,
            @RequestParam double Longitude,
            @RequestParam LocalDate date) throws IOException {
        LocalDate endDate=date.plusDays(14);
        return eventService.getEvents(Latitude,Longitude,date,endDate);
    }
    @PostMapping("/event/create")
    public String addEvent(@RequestBody Event event) {
        eventService.save(event);
        return String.valueOf(ResponseEntity.status(HttpStatus.CREATED).body("Event added successfully"));
    }

    @GetMapping("/all")
    List<Event> get(){
        return e.findAll();
    }


}
