package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
