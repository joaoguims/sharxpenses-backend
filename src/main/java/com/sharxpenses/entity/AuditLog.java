package com.sharxpenses.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    private String id;

    private String entityType;
    private String entityId;
    private String action;

    @Lob
    private String details; // pode ser JSON string

    private String actorId;
    private Instant createdAt = Instant.now();

    // getters/setters
}
