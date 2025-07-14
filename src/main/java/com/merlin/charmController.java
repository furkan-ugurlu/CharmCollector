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
    public List<charm> charms() {
        return charmService.getAllCharms();
    }
    @PostMapping
    public void saveCharm(@RequestBody  charm newCharm) {
        charmService.saveCharm(newCharm);
    }

    @GetMapping("{id}")
    public charm getCharmWithId(@PathVariable Long id) {
        return charmService.getCharmWithId(id);
    }
}
