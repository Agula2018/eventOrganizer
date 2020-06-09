package com.project.eventOrganizer.service;

import com.project.eventOrganizer.domain.Event;
import com.project.eventOrganizer.domain.User;
import com.project.eventOrganizer.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public List<Event> findEventUnassignedToUser(User user) {
        return getAllEvent().stream()
                .filter(event -> !user.getEvents().contains(event))
                .collect(Collectors.toList());
    }
}
