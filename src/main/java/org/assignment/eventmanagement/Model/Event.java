package org.assignment.eventmanagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Event {


    @Id
    @GeneratedValue
    private Long ID;
    private String eventName;
    private String cityName;
    private LocalDate date;
    private LocalTime time;
    private double latitude;
    private double longitude;


}
