package com.example.i20213tn110sdaextra2024.repository;

import com.example.i20213tn110sdaextra2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

    Optional<User> findUserById(Long id);
}
