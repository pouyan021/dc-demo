package com.pk.doublecoconutdemo.model.repository;

import com.pk.doublecoconutdemo.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
