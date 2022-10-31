package com.pk.doublecoconutdemo.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.pk.doublecoconutdemo.model.entity.Author} entity
 */
@Data
@Builder
public class AuthorCreateRequest implements Serializable {
    private final String firstName;
    private final String lastName;
    private final Instant birthDate;
    private final String email;
}
