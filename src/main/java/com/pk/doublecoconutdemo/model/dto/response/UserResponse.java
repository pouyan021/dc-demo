package com.pk.doublecoconutdemo.model.dto.response;

import com.pk.doublecoconutdemo.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Builder
public class UserResponse implements Serializable {
    private final String userName;
    private final Instant createDate;
}
