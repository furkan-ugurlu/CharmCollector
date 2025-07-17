package com.merlin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class charmService {

    private final charmRepository charmRepository;

    public charmService(charmRepository charmRepository) {
        this.charmRepository = charmRepository;
    }

    public void saveCharm(Charm newCharm) {
        charmRepository.save(newCharm);
    }

    public void deleteCharm(Long id) {
        charmRepository.deleteById(id);
    }

    public List<Charm> getAllCharms() {
        return charmRepository.findAll();
    }

    public Charm getCharmWithId(Long id) {
        return charmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charm with id " + id + " not found"));
    }
}
