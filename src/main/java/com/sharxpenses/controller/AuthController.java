package com.sharxpenses.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

record RegisterRequest(@NotBlank String name, @Email String email, @NotBlank String password) {}
record LoginRequest(@Email String email, @NotBlank String password) {}
record AuthResponse(String accessToken, String refreshToken) {}

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        // Stub: aqui você chamará o serviço para criar o usuário, enviar e-mail etc.
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        // Stub: aqui você validará credenciais e gerará JWT/refresh
        return ResponseEntity.ok(new AuthResponse("dummy-access-token", "dummy-refresh-token"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestParam String refreshToken) {
        // Stub: validar refresh e emitir novo access
        return ResponseEntity.ok(new AuthResponse("new-dummy-access-token", refreshToken));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String refreshToken) {
        // Stub: invalidar refresh token
        return ResponseEntity.noContent().build();
    }
}
