package com.backend.backend.models;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String id;
    private String title;
    private String isbn;
    private String synopsis;
    private String genre;
    private Integer publicationYear;
    private String author;
    private String publisher;

    public Book(String id, String title, String isbn, String synopsis, String genre, Integer publicationYear, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.synopsis = synopsis;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.author = author;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
