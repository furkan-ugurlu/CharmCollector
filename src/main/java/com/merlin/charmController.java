package com.merlin;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/charms")
public class charmController {

    private final charmService charmService;

    public charmController(charmService charmService) {
        this.charmService = charmService;
    }
    
    @GetMapping
    public List<Charm> charms() {
        return charmService.getAllCharms();
    }
    @PostMapping
    public void saveCharm(@RequestBody Charm newCharm) {
        charmService.saveCharm(newCharm);
    }

    @GetMapping("{id}")
    public Charm getCharmWithId(@PathVariable Long id) {
        return charmService.getCharmWithId(id);
    }
}
