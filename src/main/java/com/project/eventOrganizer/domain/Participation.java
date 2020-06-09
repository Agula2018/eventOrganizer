package com.project.eventOrganizer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "participation" )
public class Participation {

    @ManyToOne()
    @JoinColumn(name = "event_name")
    private Event event;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "approved_by_organizer")
    private boolean approvedByOrganizer;

    @Column(name = "approved_by_user")
    private boolean approvedByUser;
}
