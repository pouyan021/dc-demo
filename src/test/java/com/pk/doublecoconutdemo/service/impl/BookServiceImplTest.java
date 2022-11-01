package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.ResourceAlreadyExistException;
import com.pk.doublecoconutdemo.exception.ResourceNotExists;
import com.pk.doublecoconutdemo.model.entity.Book;
import com.pk.doublecoconutdemo.model.repository.BookRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;
    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book()
                .setTitle("Test")
                .setDescription("TEST")
                .setPublishingDate(Instant.now())
                .setPrice(1000);
    }

    @Test
    void givenTheBookObject_whenSaveBook_thenReturnBook() throws ResourceAlreadyExistException {
        //given
        given(bookRepository.save(book)).willReturn(book);

        //when
        Book savedBook = bookService.save(book);

        //then
        assertThat(savedBook).isNotNull();
    }

    @Test
    void givenBookObject_whenSaveBook_thenThrowException() {
        //given
        given(bookRepository.findByTitle(book.getTitle())).willReturn(Optional.of(book));

        //when
        assertThrows(ResourceAlreadyExistException.class, () -> bookService.save(book));

        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void givenBookObject_whenUpdateBook_thenReturnUpdateBook() throws ResourceNotExists {
        //given
        given(bookRepository.save(book)).willReturn(book);
        given(bookRepository.findById(book.getId())).willReturn(Optional.of(book));
        //when
        book.setTitle("updatedTest");

        //when
        Book updatedBook = bookService.update(book, book.getId());

        //then
        assertThat(updatedBook.getTitle()).isEqualTo("updatedTest");

    }

    @Test
    void givenBookId_whenDeleteBook_thenNothing() {
        Long id = 1L;
        //given
        willDoNothing().given(bookRepository).deleteById(id);

        //when
        bookService.remove(id);

        //then
        verify(bookRepository, times(1)).deleteById(id);
    }

    @Test
    void givenBookTitle_whenGetBookByTitle_thenReturnBook() {

        //given
        given(bookRepository.findByTitle(book.getTitle())).willReturn(Optional.of(book));

        //when
        Book savedBook = bookService.getBookByTitle(book.getTitle()).get();

        //then
        assertThat(savedBook).isNotNull();
    }
}
