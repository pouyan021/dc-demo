package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book) throws ResourceAlreadyExistException;

    Book update(Book book, Long bookId) throws ResourceNotExists;

    void remove(Long bookId);

    Optional<Book> getBookByTitle(String title);

    List<Book> getAll();
}
