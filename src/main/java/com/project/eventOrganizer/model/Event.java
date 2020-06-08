package com.project.eventOrganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "events")
public class Event {

    @Id
    @Length(min = 2, max = 50)
    private String eventName;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "access")
    private String access;

    @Column(name = "organizer")
    private String organizer;

    @ManyToMany(mappedBy = "events")
    private List<User> users;
}