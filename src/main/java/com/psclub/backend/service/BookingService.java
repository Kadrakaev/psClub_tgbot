package com.psclub.backend.service;

import com.psclub.backend.model.Booking;
import com.psclub.backend.model.GameZone;
import com.psclub.backend.model.User;
import com.psclub.backend.repository.BookingRepository;
import com.psclub.backend.repository.GameZoneRepository;
import com.psclub.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final GameZoneRepository zoneRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository repository, GameZoneRepository zoneRepository, UserRepository userRepository) {
        this.repository = repository;
        this.zoneRepository = zoneRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Long userId, Long zoneId, LocalDateTime start, LocalDateTime end) {
        User user = userRepository.findById(userId).orElseThrow();
        GameZone zone = zoneRepository.findById(zoneId).orElseThrow();

        List<Booking> conflicts = repository.findByGameZoneAndEndTimeAfterAndStartTimeBefore(zone, start, end);
        if (!conflicts.isEmpty()) {
            throw new RuntimeException("В это время зона уже забронирована");
        }

        Booking booking = Booking.builder()
                .user(user)
                .gameZone(zone)
                .startTime(start)
                .endTime(end)
                .build();

        return repository.save(booking);
    }

    public List<Booking> getByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Booking> getAll() {
        return repository.findAll();
    }
}
