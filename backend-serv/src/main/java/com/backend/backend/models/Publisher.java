package com.backend.backend.models;

import org.springframework.data.annotation.Id;

public class Publisher {
    @Id
    private String id;
    private String publisherName;
    private Integer foundationYear;

    public Publisher(String id, String publisherName, Integer foundationYear) {
        this.id = id;
        this.publisherName = publisherName;
        this.foundationYear = foundationYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }
}
