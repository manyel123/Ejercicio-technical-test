package com.backend.backend.controllers;

import com.backend.backend.models.Author;
import com.backend.backend.exceptions.AuthorNotFoundException;
import com.backend.backend.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors/id/{id}")
    Author getAuthorById(@PathVariable String id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("No se " +
                        "encontró un autor con el id: " + id));
    }

    @GetMapping("/authors/{authorName}")
    List <Author> getAuthor(@PathVariable String authorName) {
        List <Author> author =
                authorRepository.findByAuthorName(authorName).stream().collect(Collectors.toList());
        if (author.isEmpty())
            throw new AuthorNotFoundException("No existen autores con el nombre '" + authorName + "' en la base de datos.");
        return author;
    }

    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author author){
        Author authorVerify = authorRepository.findById(author.getAuthorName()).orElse(null);
        if (authorVerify != null) {
            //El nombre del autor no está disponible
            throw new AuthorNotFoundException("El autor '" + author.getAuthorName() + "' ya está registrado en la base de datos.");
        }
        return authorRepository.save(author);
    }

    @GetMapping("/authors/all")
    List <Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}