package org.assignment.eventmanagement.repo;

import org.assignment.eventmanagement.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

       List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);


}
