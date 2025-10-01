package com.sharxpenses.group.controller;

import com.sharxpenses.group.entity.Group;
import com.sharxpenses.group.service.GroupService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController {
    private final GroupService service;

    public GroupsController(GroupService service) {
        this.service = service;
    }

    @PostMapping
    public Group create(@AuthenticationPrincipal UserDetails principal, @RequestBody Group req) {
        return service.createGroup(req.getName(), principal.getUsername());
    }

    @GetMapping
    public List<Group> list() {
        return service.listGroups();
    }
}
