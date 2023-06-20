package com.inu.event.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notice {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private Notice() {

    }

    public Notice(String content) {
        this.content = content;
    }

    public Notice(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long id() {
        return id;
    }

    public String content() {
        return content;
    }
}
