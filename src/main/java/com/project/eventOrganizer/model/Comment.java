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
@Entity(name = "comment" )
public class Comment {

    @ManyToMany(mappedBy = "user_comments")
    private List<User> users;

}
