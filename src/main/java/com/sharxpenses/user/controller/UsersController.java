package com.sharxpenses.user.controller;

import com.sharxpenses.user.entity.User;
import com.sharxpenses.user.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public User me(@AuthenticationPrincipal UserDetails principal) {
        return service.getByEmail(principal.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @PutMapping("/me")
    public User updateMe(@AuthenticationPrincipal UserDetails principal, @RequestBody User updated) {
        return service.updateUser(principal.getUsername(), updated);
    }
}
