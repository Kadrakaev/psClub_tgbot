package com.psclub.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;          // Название (например, PS5 №1)

    private String description;   // Краткое описание

    private boolean available;    // Доступна ли сейчас
}
