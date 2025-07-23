package com.merlin.charm;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface CharmRepository extends JpaRepository<Charm, Long> {

    Optional<Charm> findByName(String name);
}
