package com.backend.backend.models;

import org.springframework.data.annotation.Id;

public class Author {
    @Id
    private String id;
    private String authorName;
    private String country;

    public Author(String id, String authorName, String country) {
        this.id = id;
        this.authorName = authorName;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
