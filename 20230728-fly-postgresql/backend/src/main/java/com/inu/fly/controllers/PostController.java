package com.inu.fly.controllers;

import com.inu.fly.dtos.PostDto;
import com.inu.fly.models.Post;
import com.inu.fly.repositories.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<PostDto> posts() {
        return postRepository.findAll()
            .stream()
            .map(Post::toDto)
            .toList();
    }
}
