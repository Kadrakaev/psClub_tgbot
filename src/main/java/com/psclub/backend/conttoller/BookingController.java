package com.psclub.backend.controller;

import com.psclub.backend.model.Booking;
import com.psclub.backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking create(@RequestBody Map<String, String> request) {
        Long userId = Long.parseLong(request.get("userId"));
        Long zoneId = Long.parseLong(request.get("zoneId"));
        LocalDateTime start = LocalDateTime.parse(request.get("startTime"));
        LocalDateTime end = LocalDateTime.parse(request.get("endTime"));
        return service.createBooking(userId, zoneId, start, end);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }
}
