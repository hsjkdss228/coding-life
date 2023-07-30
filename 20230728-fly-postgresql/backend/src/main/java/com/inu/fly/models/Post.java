package com.inu.fly.models;

import com.inu.fly.dtos.PostDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String descriptionText;

    private Post() {

    }

    public Post(Long id, String title, String descriptionText) {
        this.id = id;
        this.title = title;
        this.descriptionText = descriptionText;
    }

    public PostDto toDto() {
        return new PostDto(id, title, descriptionText);
    }
}
