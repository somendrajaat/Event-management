package org.assignment.eventmanagement.service;

import org.assignment.eventmanagement.Model.Event;
import org.assignment.eventmanagement.Model.Event2;
import org.assignment.eventmanagement.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepo eventRepo;
    @Autowired
    DistanceCalculationService distanceCalculationService;
    @Autowired
    WeatherService weatherService;



    public List<Event2> getEvents(double latitude, double longitude, LocalDate date, LocalDate endDate) throws IOException {
        List<Event> events=eventRepo.findByDateBetween(date,endDate);
        List<Event2> event2 = new ArrayList<>(events.size());
        for (int i = 0; i < events.size(); i++) {
            Event2 e2 = new Event2();

            e2.setEventname(events.get(i).getEventName());
            e2.setCityname(events.get(i).getCityName());
            e2.setDate(events.get(i).getDate());
            e2.setWeather(weatherService.getWeather(events.get(i).getCityName(),events.get(i).getDate()));
            e2.setDistance(distanceCalculationService.calculateDistance(latitude,longitude,events.get(i).getLatitude(),events.get(i).getLongitude()));
            event2.add(e2);
        }

        return event2;

    }
    public void save(Event event) {
        eventRepo.save(event);
    }
}
