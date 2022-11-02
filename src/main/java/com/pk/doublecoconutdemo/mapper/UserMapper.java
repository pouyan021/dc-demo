package com.pk.doublecoconutdemo.mapper;

import com.pk.doublecoconutdemo.model.dto.request.UserCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.UserResponse;
import com.pk.doublecoconutdemo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userCreateRequestToUser(UserCreateRequest userCreateRequest);

    UserResponse userToUserResponse(User user);
}
