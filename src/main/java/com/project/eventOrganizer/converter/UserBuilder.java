package com.project.eventOrganizer.converter;

import com.project.eventOrganizer.model.User;
import com.project.eventOrganizer.view.UserView;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserBuilder implements ModelConverter<User, UserView> {

    @Override
    public User convert(UserView view) {
        return User.builder()
                .login(view.getLogin())
                .password(view.getPassword())
                .email(view.getEmail())
//                .events(view.getEvents())
                .build();
    }

    @Override
    public List<UserView> convert(List<User> modelList) {
        return modelList.stream().map(this::convert).collect(Collectors.toList());
    }

    private UserView convert(User user) {
        return UserView.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
//                .events(user.getEvents())
                .build();
    }
}
