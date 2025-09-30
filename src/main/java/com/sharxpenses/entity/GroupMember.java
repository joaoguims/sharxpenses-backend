package com.sharxpenses.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "group_members",
        uniqueConstraints = @UniqueConstraint(name = "uq_group_user", columnNames = {"group_id", "user_id"}))
public class GroupMember {

    @Id
    private String id;

    @Column(name = "group_id", nullable = false)
    private String groupId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(length = 20)
    private String role = "MEMBER";

    private Instant joinedAt = Instant.now();

    // getters/setters
}
