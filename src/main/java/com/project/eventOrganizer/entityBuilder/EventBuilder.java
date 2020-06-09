package com.project.eventOrganizer.entityBuilder;

import com.project.eventOrganizer.model.Event;
import com.project.eventOrganizer.view.EventView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Event Converter
 */
@Component
public class EventBuilder implements ModelConverter<Event, EventView>{

    /**
     * Converts EventView from view to Event entity,
     * to avoid incomplete Entities in repository.
     *
     * @param view EventView
     * @return Event model
     */
    @Override
    public Event convert(EventView view) {
        return Event.builder()
                .name(view.getName())
                .date(view.getDate())
                .address(view.getAddress())
                .access(view.getAccess())
                .organizer(view.getOrganizer())
                .build();
    }

    /**
     * Converts List of Events to List of EventViews.
     *
     * @param modelList list of Event entities
     * @return list of EventView
     */
    @Override
    public List<EventView> convert(List<Event> modelList) {
        return modelList.stream().map(this::convert).collect(Collectors.toList());
    }

    private EventView convert(Event event) {
        return EventView.builder()
                .name(event.getName())
                .date(event.getDate())
                .address(event.getAddress())
                .access(event.getAccess())
                .organizer(event.getOrganizer())
                .build();
    }
}
