package com.psclub.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:3000") // Разрешаем запросы с React frontend
public class BookingController {

    @PostMapping
    public ResponseEntity<String> bookPlace(@RequestBody BookingRequest booking) {
        // Здесь можно добавить логику сохранения в базу или другую обработку
        System.out.println("Новая заявка на бронирование:");
        System.out.println("Имя: " + booking.getName());
        System.out.println("Телефон: " + booking.getPhone());
        System.out.println("Дата: " + booking.getDate());

        return ResponseEntity.ok("Бронирование принято");
    }

    // Класс для приёма JSON данных
    public static class BookingRequest {
        private String name;
        private String phone;
        private String date;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
    }
}
