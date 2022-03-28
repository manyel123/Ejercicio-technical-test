package com.backend.backend.repositories;

import com.backend.backend.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByPublisher(String publisher);
    List<Book> findByPublicationYear(Integer publicationYear);
    List<Book> findAll();
}
