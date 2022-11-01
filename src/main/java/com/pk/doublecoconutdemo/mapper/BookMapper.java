package com.pk.doublecoconutdemo.mapper;

import com.pk.doublecoconutdemo.model.dto.request.BookCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.BookResponse;
import com.pk.doublecoconutdemo.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse bookToBookResponse(Book book);

    Book bookCreateRequestToBook(BookCreateRequest bookCreateRequest);
}
