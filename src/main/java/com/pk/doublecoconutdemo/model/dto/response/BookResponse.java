package com.pk.doublecoconutdemo.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.pk.doublecoconutdemo.model.entity.Book} entity
 */
@Data
@Builder
public class BookResponse implements Serializable {
    private final String title;
    private final String description;
    private final Instant publishingDate;
    private final Integer price;
}
