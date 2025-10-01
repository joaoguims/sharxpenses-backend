package com.sharxpenses.auth.service;

import com.sharxpenses.auth.dto.*;
import com.sharxpenses.auth.util.JwtUtil;
import com.sharxpenses.user.service.UserService;
import com.sharxpenses.user.entity.User;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class AuthService {
  private final UserService users;
  private final JwtUtil jwt;

  public AuthService(UserService users, JwtUtil jwt) {
    this.users = users; this.jwt = jwt;
  }

  public AuthResponse login(LoginRequest req) {
    User u = users.findByEmail(req.email()).orElseThrow(() -> new NoSuchElementException("User not found"));
    if (!users.checkPassword(u, req.password())) throw new IllegalArgumentException("Invalid credentials");
    return new AuthResponse(jwt.generateToken(u.getEmail()), "FAKE_REFRESH");
  }

  public AuthResponse register(RegisterRequest req) {
    User u = users.create(req.email(), req.password(), req.name());
    return new AuthResponse(jwt.generateToken(u.getEmail()), "FAKE_REFRESH");
  }

  public AuthResponse refresh(String refreshToken) {
    // TODO: implementar refresh real com RefreshTokenService
    return new AuthResponse("NEW_ACCESS_" + System.currentTimeMillis(), "FAKE_REFRESH");
  }
}
