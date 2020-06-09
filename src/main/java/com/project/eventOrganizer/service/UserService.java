package com.project.eventOrganizer.service;

import com.project.eventOrganizer.domain.Status;
import com.project.eventOrganizer.domain.User;
import com.project.eventOrganizer.model.UserForm;
import com.project.eventOrganizer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUserAdmin(UserForm userForm) {
        User user = new User(userForm.getLogin(), userForm.getEmail(), userForm.getPassword(), Status.ACTIVE_ADMIN, List.of());
        userRepository.save(user);
    }
    public void createUserNonActiveUser(UserForm userForm) {
        User user = new User(userForm.getLogin(), userForm.getEmail(), userForm.getPassword(), Status.NON_ACTIVE_USER, List.of());
        userRepository.save(user);
    }

    public void deleteNonActiveUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);
    }

    public User getByUserId(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }

}
