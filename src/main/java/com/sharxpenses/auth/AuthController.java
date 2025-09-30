package com.sharxpenses.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest req) {
        return authService.register(req.getEmail(), req.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest req) {
        return authService.login(req.getEmail(), req.getPassword());
    }

    @PostMapping("/refresh")
    public String refresh(@RequestBody String oldToken) {
        return authService.refresh(oldToken); // criar método refresh se quiser expiração
    }

    @PostMapping("/logout")
    public String logout() {
        return "Logout ok (frontend deve descartar token)";
    }
}

class AuthRequest {
    private String email;
    private String password;
    // getters & setters
}
