package com.sharxpenses.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    private String id;

    @Column(nullable = false, length = 150)
    private String name;

    @Lob
    private String description;

    @Column(length = 3)
    private String currency = "BRL";

    private String createdBy;
    private Instant createdAt = Instant.now();

    // getters/setters
}
