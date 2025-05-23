package com.psclub.backend.service;

import com.psclub.backend.model.GameZone;
import com.psclub.backend.repository.GameZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameZoneService {

    private final GameZoneRepository repository;

    public GameZoneService(GameZoneRepository repository) {
        this.repository = repository;
    }

    public List<GameZone> getAll() {
        return repository.findAll();
    }

    public GameZone add(GameZone zone) {
        return repository.save(zone);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
