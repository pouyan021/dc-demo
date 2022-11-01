package com.pk.doublecoconutdemo.controller;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.mapper.BookMapper;
import com.pk.doublecoconutdemo.model.dto.request.BookCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.BookResponse;
import com.pk.doublecoconutdemo.model.entity.Book;
import com.pk.doublecoconutdemo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    public BookController(BookMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<BookResponse> getByTitle(@RequestParam String title) {
        Optional<Book> book = bookService.getBookByTitle(title);
        return book.map(value -> ResponseEntity.ok(bookMapper.bookToBookResponse(value)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponse> create(@RequestBody BookCreateRequest bookCreateRequest) throws ResourceAlreadyExistException {
        return ResponseEntity.ok(bookMapper.bookToBookResponse(bookService
                .save(bookMapper.bookCreateRequestToBook(bookCreateRequest))));
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<BookResponse> update(@RequestBody BookCreateRequest bookCreateRequest,
                                               @PathVariable Long bookId) throws ResourceNotExists {
        return ResponseEntity.ok(bookMapper.bookToBookResponse(bookService
                .update(bookMapper.bookCreateRequestToBook(bookCreateRequest), bookId)));
    }

    @DeleteMapping("/remove/{removeId}")
    public ResponseEntity remove(@PathVariable Long removeId) {
        bookService.remove(removeId);
        return ResponseEntity.ok().build();
    }

}
