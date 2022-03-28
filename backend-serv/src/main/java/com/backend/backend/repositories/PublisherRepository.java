package com.backend.backend.repositories;

import com.backend.backend.models.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PublisherRepository extends MongoRepository<Publisher, String>{
    Publisher findPublisherById(String id);
    List<Publisher> findByPublisherName(String publisherName);
    List<Publisher> findAll();
}

