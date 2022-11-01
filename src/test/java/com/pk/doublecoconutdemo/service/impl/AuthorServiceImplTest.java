package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Author;
import com.pk.doublecoconutdemo.model.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author()
                .setName("Pouyan")
                .setEmail("some.email@gmail.com")
                .setBirthDate(Instant.now());
    }

    @Test
    void givenTheAuthorObject_whenSaveAuthor_thenReturnAuthor() throws ResourceAlreadyExistException {
        //given
        given(authorRepository.save(author)).willReturn(author);

        //when
        Author savedAuthor = authorService.save(author);

        //then
        assertThat(savedAuthor).isNotNull();
    }

    @Test
    void givenTheAuthorObject_whenSaveAuthor_thenThrowException() {
        //given
        given(authorRepository.findByName(author.getName())).willReturn(Optional.of(author));

        //when
        assertThrows(ResourceAlreadyExistException.class, () -> authorService.save(author));

        //then
        verify(authorRepository, never()).save(any(Author.class));
    }

    @Test
    void givenTheAuthorObject_whenUpdateAuthor_thenReturnAuthor() throws ResourceNotExists {
        //given
        given(authorRepository.save(author)).willReturn(author);
        given(authorRepository.findById(author.getId())).willReturn(Optional.of(author));

        //when
        author.setEmail("someOther.email@gmail.com");
        Author savedAuthor = authorService.update(author, author.getId());
        //then
        assertThat(savedAuthor.getEmail()).isEqualTo("someOther.email@gmail.com");
    }

    @Test
    void givenTheAuthorName_whenGetAuthor_thenReturnAuthor() {
        //given
        given(authorRepository.findByName(author.getName())).willReturn(Optional.of(author));

        //when
        var savedAuthor = authorService.getAuthorByName(author.getName());

        //then
        assertThat(savedAuthor).isNotNull();
    }

    @Test
    void givenAuthorId_whenRemoveAuthor_thenNothing() {
        //given
        willDoNothing().given(authorRepository).deleteById(author.getId());

        //when
        authorService.remove(author.getId());

        //then
        verify(authorRepository, times(1)).deleteById(author.getId());
    }
}
