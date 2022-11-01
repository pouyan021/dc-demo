package com.pk.doublecoconutdemo.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Author} entity
 */
@Data
@Builder
public class AuthorResponse implements Serializable {
    private final String name;
    private final Instant birthDate;
    private final String email;
}
