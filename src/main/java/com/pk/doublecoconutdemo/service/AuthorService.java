package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Author;

import java.util.Optional;

public interface AuthorService {
    Author save(Author author) throws ResourceAlreadyExistException;

    Author update(Author author, Long authorId) throws ResourceNotExists;

    void remove(Long authorId);

    Optional<Author> getAuthorByName(String name);
}
