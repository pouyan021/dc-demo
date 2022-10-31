package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
