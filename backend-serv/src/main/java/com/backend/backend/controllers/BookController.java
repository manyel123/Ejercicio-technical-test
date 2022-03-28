package com.backend.backend.controllers;

import com.backend.backend.models.Book;
import com.backend.backend.exceptions.BookNotFoundException;
import com.backend.backend.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/id/{id}")
    Book getBookById(@PathVariable String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("No se " +
                        "encontró un libro con el id: " + id));
    }

    @GetMapping("/books/title/{title}")
    List <Book> getBooksByTitle(@PathVariable String title) {
        List <Book> booksByTitle =
                bookRepository.findByTitle(title).stream().collect(Collectors.toList());
        if (booksByTitle.isEmpty())
            throw new BookNotFoundException("No existen libros con el título '" + title + "' en la base de datos.");
        return booksByTitle;
    }

    @GetMapping("/books/author/{author}")
    List <Book> getBooksByAuthor(@PathVariable String author) {
        List <Book> booksByAuthor =
                bookRepository.findByAuthor(author).stream().collect(Collectors.toList());
        if (booksByAuthor.isEmpty())
            throw new BookNotFoundException("No existen libros con el autor '" + author + "' en la base de datos.");
        return booksByAuthor;
    }

    @GetMapping("/books/publisher/{publisher}")
    List <Book> getBooksByPublisher(@PathVariable String publisher) {
        List <Book> booksByPublisher =
                bookRepository.findByPublisher(publisher).stream().collect(Collectors.toList());
        if (booksByPublisher.isEmpty())
            throw new BookNotFoundException("No existen libros con el editor '" + publisher + "' en la base de datos.");
        return booksByPublisher;
    }

    @GetMapping("/books/year/{publicationYear}")
    List <Book> getBooksByPublicationYear(@PathVariable Integer publicationYear) {
        List <Book> booksByPublicationYear =
                bookRepository.findByPublicationYear(publicationYear).stream().collect(Collectors.toList());
        if (booksByPublicationYear.isEmpty())
            throw new BookNotFoundException("No existen libros con año de publicación '" + publicationYear + "' en la base de datos.");
        return booksByPublicationYear;
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book book){
        Book bookVerify = bookRepository.findById(book.getIsbn()).orElse(null);
        if (bookVerify != null) {
            throw new BookNotFoundException("El libro con ISBN '" + book.getIsbn() + "' ya está registrado en la base de datos.");
        }
        return bookRepository.save(book);
    }

    @GetMapping("/books/all")
    List <Book> getAllBooks(){
        return bookRepository.findAll();
    }
}