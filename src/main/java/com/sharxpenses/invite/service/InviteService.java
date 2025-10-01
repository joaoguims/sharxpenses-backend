package com.sharxpenses.invite.service;

import com.sharxpenses.group.entity.Group;
import com.sharxpenses.group.entity.GroupMember;
import com.sharxpenses.group.repository.GroupMemberRepository;
import com.sharxpenses.group.repository.GroupRepository;
import com.sharxpenses.invite.entity.Invite;
import com.sharxpenses.invite.repository.InviteRepository;
import com.sharxpenses.user.entity.User;
import com.sharxpenses.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class InviteService {
    private final InviteRepository inviteRepo;
    private final GroupRepository groupRepo;
    private final GroupMemberRepository memberRepo;
    private final UserRepository userRepo;

    public InviteService(InviteRepository inviteRepo, GroupRepository groupRepo, GroupMemberRepository memberRepo, UserRepository userRepo) {
        this.inviteRepo = inviteRepo; this.groupRepo = groupRepo; this.memberRepo = memberRepo; this.userRepo = userRepo;
    }

    public Invite createInvite(Long groupId) {
        Group g = groupRepo.findById(groupId).orElseThrow();
        Invite inv = new Invite();
        inv.setGroup(g);
        inv.setToken(UUID.randomUUID().toString());
        inv.setExpiresAt(Instant.now().plusSeconds(3600));
        return inviteRepo.save(inv);
    }

    public void acceptInvite(String token, String userEmail) {
        Invite inv = inviteRepo.findByToken(token).orElseThrow(() -> new RuntimeException("Invite inválido"));
        if (inv.isUsed() || inv.getExpiresAt().isBefore(Instant.now())) throw new RuntimeException("Convite expirado/uso inválido");
        User u = userRepo.findByEmail(userEmail).orElseThrow();
        GroupMember gm = new GroupMember();
        gm.setGroup(inv.getGroup());
        gm.setUser(u);
        gm.setRole(GroupMember.Role.MEMBER);
        memberRepo.save(gm);
        inv.setUsed(true);
        inviteRepo.save(inv);
    }
}
