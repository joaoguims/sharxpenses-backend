package com.sharxpenses.group.service;

import com.sharxpenses.group.entity.Group;
import com.sharxpenses.group.entity.GroupMember;
import com.sharxpenses.group.repository.GroupRepository;
import com.sharxpenses.group.repository.GroupMemberRepository;
import com.sharxpenses.user.entity.User;
import com.sharxpenses.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepo;
    private final GroupMemberRepository memberRepo;
    private final UserRepository userRepo;

    public GroupService(GroupRepository groupRepo, GroupMemberRepository memberRepo, UserRepository userRepo) {
        this.groupRepo = groupRepo; this.memberRepo = memberRepo; this.userRepo = userRepo;
    }

    public Group createGroup(String name, String emailOwner) {
        User owner = userRepo.findByEmail(emailOwner).orElseThrow();
        Group g = new Group();
        g.setName(name);
        Group saved = groupRepo.save(g);
        GroupMember gm = new GroupMember();
        gm.setGroup(saved);
        gm.setUser(owner);
        gm.setRole(GroupMember.Role.ADMIN);
        memberRepo.save(gm);
        return saved;
    }

    public List<Group> listGroups() {
        return groupRepo.findAll();
    }
}
