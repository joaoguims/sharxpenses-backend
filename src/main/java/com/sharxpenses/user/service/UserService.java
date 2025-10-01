package com.sharxpenses.user.service;

import com.sharxpenses.user.entity.User;
import com.sharxpenses.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo; this.encoder = encoder;
    }

    public User create(String email, String rawPassword, String name) {
        User u = new User();
        u.setEmail(email);
        u.setPassword(encoder.encode(rawPassword));
        u.setName(name);
        return repo.save(u);
    }

    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public boolean checkPassword(User user, String raw) {
        return encoder.matches(raw, user.getPassword());
    }

    public Optional<User> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public User updateUser(String email, User updated) {
        User u = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (updated.getName() != null) u.setName(updated.getName());
        if (updated.getAvatarUrl() != null) u.setAvatarUrl(updated.getAvatarUrl());
        // TODO: adicionar suporte a preferências simples
        return repo.save(u);
    }
}
