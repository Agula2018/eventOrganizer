package com.project.eventOrganizer.repository;

import com.project.eventOrganizer.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
