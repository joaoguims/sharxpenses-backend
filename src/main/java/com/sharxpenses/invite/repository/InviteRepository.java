﻿package com.sharxpenses.invite.repository;

import com.sharxpenses.invite.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    Optional<Invite> findByToken(String token);
}
