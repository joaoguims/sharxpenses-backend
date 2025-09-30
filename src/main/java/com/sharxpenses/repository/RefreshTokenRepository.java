package com.sharxpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharxpenses.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> { }
