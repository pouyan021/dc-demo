package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Author;
import com.pk.doublecoconutdemo.model.repository.AuthorRepository;
import com.pk.doublecoconutdemo.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) throws ResourceAlreadyExistException {
        if (authorRepository.findByName(author.getName()).isPresent()) {
            throw new ResourceAlreadyExistException("Author has already been added");
        }
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author, Long authorId) throws ResourceNotExists {
        if (authorRepository.findById(authorId).isEmpty()) {
            throw new ResourceNotExists("Such author does not exist");
        }
        return authorRepository.save(author);
    }

    @Override
    public void remove(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
