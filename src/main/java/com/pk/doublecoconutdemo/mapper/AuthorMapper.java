package com.pk.doublecoconutdemo.mapper;

import com.pk.doublecoconutdemo.model.dto.request.AuthorCreateRequest;
import com.pk.doublecoconutdemo.model.dto.response.AuthorResponse;
import com.pk.doublecoconutdemo.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorResponse authorToAuthorResponse(Author author);

    Author authorRequestToAuthor(AuthorCreateRequest request);
}
