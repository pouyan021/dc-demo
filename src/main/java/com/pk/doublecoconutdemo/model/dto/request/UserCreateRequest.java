package com.pk.doublecoconutdemo.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
// * A DTO for the {@link com.pk.doublecoconutdemo.model.entity.User} entity
 */
@Data
@Builder
public class UserCreateRequest implements Serializable {
    private final String userName;
    private final String password;
}
