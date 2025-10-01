package com.sharxpenses.invite.controller;

import com.sharxpenses.invite.entity.Invite;
import com.sharxpenses.invite.service.InviteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invites")
public class InvitesController {
    private final InviteService service;

    public InvitesController(InviteService service) {
        this.service = service;
    }

    @PostMapping("/accept")
    public String accept(@AuthenticationPrincipal UserDetails principal, @RequestParam String token) {
        service.acceptInvite(token, principal.getUsername());
        return "Convite aceito!";
    }
}
