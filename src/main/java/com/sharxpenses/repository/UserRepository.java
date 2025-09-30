package com.sharxpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharxpenses.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
