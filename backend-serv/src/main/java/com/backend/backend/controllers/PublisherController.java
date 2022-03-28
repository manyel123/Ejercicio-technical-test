package com.backend.backend.controllers;

import com.backend.backend.exceptions.AuthorNotFoundException;
import com.backend.backend.models.Author;
import com.backend.backend.models.Publisher;
import com.backend.backend.exceptions.PublisherNotFoundException;
import com.backend.backend.repositories.PublisherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/publishers/id/{id}")
    Publisher getPublisherById(@PathVariable String id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException("No se " +
                        "encontró un autor con el id: " + id));
    }

    @GetMapping("/publishers/{publisherName}")
    List <Publisher> getPublisher(@PathVariable String publisherName) {
        List <Publisher> publisher =
                publisherRepository.findByPublisherName(publisherName).stream().collect(Collectors.toList());
        if (publisher.isEmpty())
                throw new PublisherNotFoundException("No se encontró el editor '" + publisherName + "' en la base de datos.");
        return publisher;
    }

    @PostMapping("/publishers")
    Publisher newPublisher(@RequestBody Publisher publisher){
        Publisher publisherVerify = publisherRepository.findById(publisher.getPublisherName()).orElse(null);
        if (publisherVerify != null) {
            throw new PublisherNotFoundException("El editor " + publisher.getPublisherName() + " ya está registrado en la base de datos.");
        }
        return publisherRepository.save(publisher);
    }

    @GetMapping("/publishers/all")
    List <Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }
}