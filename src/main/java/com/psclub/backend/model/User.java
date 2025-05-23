package com.psclub.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String telegramId;  // telegram user id, уникальный

    @Column(nullable = false)
    private String username;  // ник в Telegram

    @Column(nullable = false)
    private String fullName;

    // Можно добавить другие поля, например email, телефон и т.п.
}
