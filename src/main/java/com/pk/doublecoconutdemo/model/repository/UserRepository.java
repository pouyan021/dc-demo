package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
