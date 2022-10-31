package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
