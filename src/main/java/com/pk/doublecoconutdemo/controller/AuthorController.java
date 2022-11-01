package com.pk.doublecoconutdemo.controller;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.mapper.AuthorMapper;
import com.pk.doublecoconutdemo.model.dto.request.AuthorCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.AuthorResponse;
import com.pk.doublecoconutdemo.model.entity.Author;
import com.pk.doublecoconutdemo.service.AuthorService;
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
@RequestMapping("/api/author")
public class AuthorController {


    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public ResponseEntity<AuthorResponse> getAuthorByName(@RequestParam("name") String name) {
        Optional<Author> author = authorService.getAuthorByName(name);
        return author.map(value -> ResponseEntity.ok(authorMapper.authorToAuthorResponse(value)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorCreateRequest authorCreateRequest)
            throws ResourceAlreadyExistException {
        return ResponseEntity.ok(authorMapper.authorToAuthorResponse(authorService
                .save(authorMapper.authorRequestToAuthor(authorCreateRequest))));
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<AuthorResponse> update(@RequestBody AuthorCreateRequest authorCreateRequest,
                                                 @PathVariable Long authorId) throws ResourceNotExists {
        return ResponseEntity.ok(authorMapper.authorToAuthorResponse(authorService
                .update(authorMapper.authorRequestToAuthor(authorCreateRequest), authorId)));
    }

    @DeleteMapping("/remove/{authorId}")
    public ResponseEntity delete(@PathVariable Long authorId) {
        authorService.remove(authorId);
        return ResponseEntity.ok().build();
    }

}
