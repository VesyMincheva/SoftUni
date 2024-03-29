package com.softuin.Battleships.repository;

import com.softuin.Battleships.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsernameAndPassword(String username, String password);

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserById(long id);
}
