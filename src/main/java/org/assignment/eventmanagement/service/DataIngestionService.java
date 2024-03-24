package org.assignment.eventmanagement.service;

import org.assignment.eventmanagement.Model.Event;
import org.assignment.eventmanagement.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.DateTimeParseException;

@Service
public class DataIngestionService {

    @Autowired
    private EventRepo eventRepository;

    @Transactional
    public void ingestDataFromCSV() {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/dataset.csv"));


            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Event event = new Event();
                    event.setEventName(data[0]);
                    event.setCityName(data[1]);
                    event.setDate(LocalDate.parse(data[2]));
                    try {
                        event.setTime(LocalTime.parse(data[3]));
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parsing time: " + data[3]);
                        // Handle the error (e.g., log it, set a default value, or skip the record)
                    }

                    event.setLatitude(Double.parseDouble(data[4]));
                    event.setLongitude(Double.parseDouble(data[5]));

                    eventRepository.save(event);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
