package com.project.eventOrganizer.service;

import com.project.eventOrganizer.converter.UserBuilder;
import com.project.eventOrganizer.repository.UserRepository;
import com.project.eventOrganizer.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserBuilder builder;

    public void add(UserView userView){
        repository.save(builder.convert(userView));
    }

    public List<UserView> findAll(){
        return builder.convert(repository.findAll());
    }
}
