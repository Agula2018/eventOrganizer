package com.project.eventOrganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventForm {

    @Length(min = 2, max = 50)
    private String eventName;

    @NotNull
    private LocalDateTime date;
    private String address;
    private String access;
    private String organizer;

}
