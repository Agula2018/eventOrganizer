package com.project.eventOrganizer.model;

import com.project.eventOrganizer.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {


    @NotNull
    private String login;

    @NotNull
    @Email
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

}
