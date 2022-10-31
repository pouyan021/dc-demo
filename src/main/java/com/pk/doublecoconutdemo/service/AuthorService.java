package com.pk.doublecoconutdemo.service;

import com.pk.doublecoconutdemo.model.dto.request.AuthorCreateRequest;
import com.pk.doublecoconutdemo.model.entity.Author;

public interface AuthorService {

    Author save(AuthorCreateRequest authorCreateRequest);

}
