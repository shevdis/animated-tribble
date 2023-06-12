package com.example.backend.repositories;

import java.util.Optional;
import com.example.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByToken(String token);

    Optional<User> findByLogin(String login);

}
