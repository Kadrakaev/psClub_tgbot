package com.psclub.backend.controller;

import com.psclub.backend.model.GameZone;
import com.psclub.backend.service.GameZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@CrossOrigin
public class GameZoneController {

    private final GameZoneService service;

    public GameZoneController(GameZoneService service) {
        this.service = service;
    }

    @GetMapping
    public List<GameZone> getAll() {
        return service.getAll();
    }

    @PostMapping
    public GameZone add(@RequestBody GameZone zone) {
        return service.add(zone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
