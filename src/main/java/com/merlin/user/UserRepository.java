package com.merlin.user;

import com.merlin.charm.Charm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String normalizedName);
}