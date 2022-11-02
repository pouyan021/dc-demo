package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.exception.UserAlreadyExistException;
import com.pk.doublecoconutdemo.model.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user) throws UserAlreadyExistException;

    void remove(Long userId);

    Optional<User> getbyUserName(String userName);

}
