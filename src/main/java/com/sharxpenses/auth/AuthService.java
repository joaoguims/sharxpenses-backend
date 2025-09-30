package com.sharxpenses.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepo, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    public String register(String email, String password) {
        if (userRepo.existsByEmail(email)) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        userRepo.save(user);
        return jwtUtil.generateToken(email);
    }

    public String login(String email, String password) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }
        return jwtUtil.generateToken(email);
    }
}
