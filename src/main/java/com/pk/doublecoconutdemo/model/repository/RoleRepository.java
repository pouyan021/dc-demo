package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
