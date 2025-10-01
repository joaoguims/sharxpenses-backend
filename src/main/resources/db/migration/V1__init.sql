CREATE TABLE users (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(150),
  email VARCHAR(255) NOT NULL UNIQUE,
  password_hash VARCHAR(255),
  avatar_url VARCHAR(512),
  enabled BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE groups (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  description TEXT,
  currency VARCHAR(3) DEFAULT 'BRL',
  created_by VARCHAR(36),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE group_members (
  id VARCHAR(36) PRIMARY KEY,
  group_id VARCHAR(36) NOT NULL,
  user_id VARCHAR(36) NOT NULL,
  role VARCHAR(16) DEFAULT 'member',
  joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (group_id, user_id)
);

CREATE TABLE expenses (
  id VARCHAR(36) PRIMARY KEY,
  group_id VARCHAR(36) NOT NULL,
  payer_id VARCHAR(36) NOT NULL,
  amount DECIMAL(12,2) NOT NULL,
  category VARCHAR(64),
  description TEXT,
  date TIMESTAMP,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE expense_shares (
  id VARCHAR(36) PRIMARY KEY,
  expense_id VARCHAR(36) NOT NULL,
  user_id VARCHAR(36) NOT NULL,
  amount_due DECIMAL(12,2) NOT NULL,
  amount_paid DECIMAL(12,2) DEFAULT 0,
  status VARCHAR(16) DEFAULT 'OPEN'
);

CREATE TABLE invites (
  token VARCHAR(64) PRIMARY KEY,
  group_id VARCHAR(36) NOT NULL,
  inviter_id VARCHAR(36) NOT NULL,
  email VARCHAR(255),
  expires_at TIMESTAMP,
  used BOOLEAN DEFAULT FALSE
);

CREATE TABLE audit_logs (
  id VARCHAR(36) PRIMARY KEY,
  entity_type VARCHAR(64),
  entity_id VARCHAR(36),
  action VARCHAR(64),
  actor_id VARCHAR(36),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
