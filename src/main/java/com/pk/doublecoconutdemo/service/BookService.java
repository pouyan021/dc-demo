package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.model.dto.request.BookCreateRequest;
import com.pk.doublecoconutdemo.model.entity.Book;

public interface BookService {
    Book save(BookCreateRequest bookCreateRequest);
}
