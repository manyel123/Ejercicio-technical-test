package com.backend.backend.repositories;

import com.backend.backend.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String>{
    List<Author> findByAuthorName(String authorName);
    List<Author> findAll();
}
