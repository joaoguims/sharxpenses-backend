package com.sharxpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharxpenses.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, String> { }
