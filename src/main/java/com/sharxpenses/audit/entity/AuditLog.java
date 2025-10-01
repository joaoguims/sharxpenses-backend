package com.sharxpenses.audit.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

  @Id
  private String id = UUID.randomUUID().toString();

  @Column(nullable = false)
  private String entityType;

  @Column(nullable = false)
  private String entityId;

  @Column(nullable = false)
  private String action;

  @Column(nullable = false)
  private String actorId;

  @Column(nullable = false, updatable = false)
  private Instant timestamp = Instant.now();

  public AuditLog() {}

  public AuditLog(String entityType, String entityId, String action, String actorId) {
    this.entityType = entityType;
    this.entityId = entityId;
    this.action = action;
    this.actorId = actorId;
    this.timestamp = Instant.now();
  }

  // Getters e Setters
  public String getId() { return id; }
  public String getEntityType() { return entityType; }
  public void setEntityType(String entityType) { this.entityType = entityType; }
  public String getEntityId() { return entityId; }
  public void setEntityId(String entityId) { this.entityId = entityId; }
  public String getAction() { return action; }
  public void setAction(String action) { this.action = action; }
  public String getActorId() { return actorId; }
  public void setActorId(String actorId) { this.actorId = actorId; }
  public Instant getTimestamp() { return timestamp; }
  public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
