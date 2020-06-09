package com.project.eventOrganizer.repository;

import com.project.eventOrganizer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
