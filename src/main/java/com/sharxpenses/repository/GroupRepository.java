package com.sharxpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sharxpenses.entity.Group;

public interface GroupRepository extends JpaRepository<Group, String> { }
