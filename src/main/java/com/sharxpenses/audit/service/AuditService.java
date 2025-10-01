package com.sharxpenses.audit.service;

import com.sharxpenses.audit.entity.AuditLog;
import com.sharxpenses.audit.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    private final AuditLogRepository repo;

    public AuditService(AuditLogRepository repo) { this.repo = repo; }

    public void log(String type, String id, String action, String actor) {
        AuditLog log = new AuditLog();
        log.setEntityType(type);
        log.setEntityId(id);
        log.setAction(action);
        log.setActorId(actor);
        repo.save(log);
    }
}
