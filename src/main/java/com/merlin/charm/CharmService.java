package com.merlin.charm;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharmService {

    private final CharmRepository charmRepository;

    public CharmService(CharmRepository charmRepository) {
        this.charmRepository = charmRepository;
    }

    public Charm saveCharm(Charm newCharm) {
        // Null check
        if (newCharm == null || newCharm.getName() == null || newCharm.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Charm and charm name cannot be null or empty");
        }

        // Normalize name
        String normalizedName = newCharm.getName().trim();
        newCharm.setName(normalizedName);

        // Check if exists
        Optional<Charm> existing = charmRepository.findByName(normalizedName);
        if (existing.isPresent()) {
            throw new RuntimeException("Charm with name '" + normalizedName + "' already exists");
        }

        return charmRepository.save(newCharm);
    }

    public void deleteCharm(Long id) {
        charmRepository.deleteById(id);
    }

    public List<Charm> getAllCharms() {
        return charmRepository.findAll();
    }

    public Charm getCharmWithName(String name) {
        return charmRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Charm with name " + name + " not found"));
    }

    public void deleteAll() {
        charmRepository.deleteAll();
    }
}
