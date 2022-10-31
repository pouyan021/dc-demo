package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.model.dto.request.UserCreateRequest;
import com.pk.doublecoconutdemo.model.entity.User;

public interface UserService {
    User save(UserCreateRequest userCreateRequest);

    void remove(int userId);
}
