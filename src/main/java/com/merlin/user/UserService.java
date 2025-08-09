package com.merlin.user;

import com.merlin.charm.Charm;
import com.merlin.charm.CharmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CharmRepository charmRepository; // You need this too.

    public UserService(UserRepository userRepository, CharmRepository charmRepository) {
        this.userRepository = userRepository;
        this.charmRepository = charmRepository;
    }

    @Transactional
    public void addCharmToUser(Long userId, Long charmId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Charm charm = charmRepository.findById(charmId)
                .orElseThrow(() -> new RuntimeException("Charm not found"));


        user.getCharms().add(charm);
        charm.setUser(user); // Assuming Charm has a User field to maintain the relationship
        userRepository.save(user);
    }

    @Transactional
    public void removeCharmFromUser(Long userId, Long charmId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Charm charm = charmRepository.findById(charmId)
                .orElseThrow(() -> new RuntimeException("Charm not found"));

        user.getCharms().remove(charm);
        // Clear the relationship on the charm to keep the association consistent
        charm.setUser(null);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        // Null check
        if (user == null || user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("User and username cannot be null or empty");
        }

        // Normalize username
        String normalizedUsername = user.getName().trim();
        user.setName(normalizedUsername);

        // Check if exists
        Optional<User> existing = userRepository.findByName(normalizedUsername);
        if (existing.isPresent()) {
            throw new RuntimeException("User with username '" + normalizedUsername + "' already exists");
        }

        return userRepository.save(user);
    }
}

