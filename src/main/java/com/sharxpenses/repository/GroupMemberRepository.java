package com.sharxpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharxpenses.entity.GroupMember;

public interface GroupMemberRepository extends JpaRepository<GroupMember, String> { }
