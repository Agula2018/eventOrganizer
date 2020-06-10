package com.project.eventOrganizer.view;

import com.project.eventOrganizer.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

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
//    private List<User> users;

}
