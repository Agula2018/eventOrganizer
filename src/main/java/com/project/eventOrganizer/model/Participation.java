package com.project.eventOrganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "participation" )
public class Participation {

    @ManyToMany(mappedBy = "events")
    private List<Event> events;

    @ManyToMany(mappedBy = "users")
    private List<User> users;

    private boolean approvedByOrganizer;
    private boolean approvedByUser;
}
