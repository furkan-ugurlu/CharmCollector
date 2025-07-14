package com.merlin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/charms")
public class charmController {

    @GetMapping
    public List<charm> charms() {
        return List.of(
                new charm("Merlin", "Blue", "Magic"),
                new charm("Arthur", "Gold", "Leadership"),
                new charm("Gwen", "Green", "Wisdom"),
                new charm("Morgana", "Black", "Mystery")
        );

    }

}
