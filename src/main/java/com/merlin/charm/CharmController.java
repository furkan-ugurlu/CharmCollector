package com.merlin.charm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/charms")
public class CharmController {

    private final CharmService charmService;

    public CharmController(CharmService charmService) {
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

    @GetMapping("/{name}")
    public Charm getCharmWithName(@PathVariable String name) {
        return charmService.getCharmWithName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteCharm(@PathVariable Long id) {
        charmService.deleteCharm(id);
    }

    @DeleteMapping
    public String deleteAllCharms() {
        charmService.deleteAll();
        return "All charms deleted successfully";
    }
}
