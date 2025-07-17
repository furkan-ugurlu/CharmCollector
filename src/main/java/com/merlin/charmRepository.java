package com.merlin;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface charmRepository extends JpaRepository<Charm, Long> {

}
