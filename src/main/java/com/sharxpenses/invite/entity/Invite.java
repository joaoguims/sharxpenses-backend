package com.sharxpenses.invite.entity;

import com.sharxpenses.group.entity.Group;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "invites")
public class Invite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne
    private Group group;

    private Instant expiresAt;

    private boolean used = false;

    public Long getId() { return id; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }
    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
    public boolean isUsed() { return used; }
    public void setUsed(boolean used) { this.used = used; }
}
