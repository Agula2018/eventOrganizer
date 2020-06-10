package com.project.eventOrganizer.repository;

import com.project.eventOrganizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u left join fetch u.events WHERE u.id = :id")
    Optional<User> findUserByUserIdWithEvents(@Param("id") final Long id);

}
