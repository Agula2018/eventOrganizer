package com.project.eventOrganizer.service;

import com.project.eventOrganizer.entityBuilder.EventBuilder;
import com.project.eventOrganizer.repository.EventRepository;
import com.project.eventOrganizer.view.EventView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository repository;
    private final EventBuilder builder;

    public void add(EventView eventView) {
        repository.save(builder.convert(eventView));
    }

    public List<EventView> findAll() {
        return builder.convert(repository.findAll());
    }
}
