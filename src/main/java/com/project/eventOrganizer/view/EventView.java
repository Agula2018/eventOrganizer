package com.project.eventOrganizer.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventView {

    private String name;
    private LocalDateTime date;
    private String address;
    private String access;
    private String organizer;

}
