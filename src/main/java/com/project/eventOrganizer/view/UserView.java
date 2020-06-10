package com.project.eventOrganizer.view;

import com.project.eventOrganizer.model.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserView {


    private String login;
    private String password;
    private String email;
//    private List<Event> events;
}
