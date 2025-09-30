package com.sharxpenses.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    private String avatarUrl;
    private String preferredCurrency = "BRL";
    private Boolean notificationsEnabled = true;
    private Boolean enabled = false;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    // getters/setters
    // (pode gerar com Lombok se preferir)
}
