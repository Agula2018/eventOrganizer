package com.project.eventOrganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @Length(min = 2, max = 4)
    private Long id;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column
    private String displayName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(name = "users_to_events",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "name"))
    private List<Event> roles = new ArrayList<>();
}
