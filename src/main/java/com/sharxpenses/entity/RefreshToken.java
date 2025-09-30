package com.sharxpenses.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "token_hash", nullable = false, length = 512)
    private String tokenHash;

    private String deviceId;
    private Instant createdAt = Instant.now();
    private Instant expiresAt;
    private Boolean revoked = false;

    // getters/setters
}
