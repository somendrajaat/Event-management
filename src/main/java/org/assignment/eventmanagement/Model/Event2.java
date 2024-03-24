package org.assignment.eventmanagement.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Event2 {

    private String eventname;
    private String cityname;
    private LocalDate date;
    private String weather;
    private double distance;
}
