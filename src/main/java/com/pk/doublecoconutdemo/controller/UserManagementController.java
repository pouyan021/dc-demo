package com.pk.doublecoconutdemo.controller;

import com.pk.doublecoconutdemo.exception.UserAlreadyExistException;
import com.pk.doublecoconutdemo.mapper.UserMapper;
import com.pk.doublecoconutdemo.model.dto.request.UserCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.UserResponse;
import com.pk.doublecoconutdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserManagementController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest request) throws UserAlreadyExistException {
        return ResponseEntity.ok(userMapper.userToUserResponse(userService
                .save(userMapper.userCreateRequestToUser(request))));
    }
}
