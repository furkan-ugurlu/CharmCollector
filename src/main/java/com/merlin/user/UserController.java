package com.merlin.user;

import com.merlin.charm.Charm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(201).body(createdUser);
        }
        @PostMapping("/{userId}/charms/{charmId}")
        public ResponseEntity<Void> addCharmToUser(@PathVariable Long userId, @PathVariable Long charmId) {
            userService.addCharmToUser(userId, charmId);
            return ResponseEntity.ok().build();
        }

        @DeleteMapping("/{userId}/charms/{charmId}")
        public ResponseEntity<Void> removeCharmFromUser(@PathVariable Long userId, @PathVariable Long charmId) {
            userService.removeCharmFromUser(userId, charmId);
            return ResponseEntity.ok().build();
        }
    }

