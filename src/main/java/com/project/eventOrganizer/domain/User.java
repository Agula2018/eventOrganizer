package com.project.eventOrganizer.domain;

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

    public <E> User(String login, String email, String password, Status activeAdmin, List<E> of) {
    }

    @Id
    @Length(min = 2, max = 4)
    private Long userId;

    @Column
    @Length(min = 2, max = 50)
    private String login;


    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(name = "users_to_events",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "eventName"))
    private List<Event> events = new ArrayList<>();

}
