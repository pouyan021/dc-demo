package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Book;
import com.pk.doublecoconutdemo.model.repository.BookRepository;
import com.pk.doublecoconutdemo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) throws ResourceAlreadyExistException {
        if (bookRepository.findByTitle(book.getTitle()).isPresent()) {
            throw new ResourceAlreadyExistException("Book already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, Long bookId) throws ResourceNotExists {
        if (bookRepository.findById(bookId).isEmpty()) {
            throw new ResourceNotExists("Such book doesn't exist");
        }
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getAll() {
       return  bookRepository.findAll();
    }
}
