package com.psclub.backend.repository;

import com.psclub.backend.model.Booking;
import com.psclub.backend.model.GameZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGameZoneAndEndTimeAfterAndStartTimeBefore(
            GameZone gameZone,
            LocalDateTime start,
            LocalDateTime end
    );

    List<Booking> findByUserId(Long userId);
}
