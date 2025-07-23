package com.merlin.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
     void deleteByName(String name);

    Optional<Category> findByName(String normalizedName);
}
