package com.project.eventOrganizer.converter;

import com.project.eventOrganizer.model.Event;
import com.project.eventOrganizer.view.EventView;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventBuilder implements ModelConverter<Event, EventView>{


    @Override
    public Event convert(EventView view) {
        return Event.builder()
                .name(view.getName())
                .date(view.getDate())
                .address(view.getAddress())
                .access(view.getAccess())
                .organizer(view.getOrganizer())
//                .users(view.getUsers())
                .build();
    }

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
//                .users(event.getUsers())
                .build();
    }
}
