package com.pk.doublecoconutdemo.mapper;

import com.pk.doublecoconutdemo.model.dto.request.AuthorCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.AuthorResponse;
import com.pk.doublecoconutdemo.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponse authorToAuthorResponse(Author author);

    Author authorRequestToAuthor(AuthorCreateRequest request);

   List<AuthorResponse> map(List<Author> authors);
}
