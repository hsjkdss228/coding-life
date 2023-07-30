package com.inu.fly.controllers;

import com.inu.fly.models.Post;
import com.inu.fly.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostRepository postRepository;

    @Test
    void posts() throws Exception {
        List<Post> posts = List.of(
            new Post(1L, "title1", "content1"),
            new Post(2L, "title2", "content2"),
            new Post(3L, "title3", "content3")
        );
        given(postRepository.findAll()).willReturn(posts);

        mockMvc.perform(get("/posts"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("title1")))
            .andExpect(content().string(containsString("title2")))
            .andExpect(content().string(containsString("title3")));
    }
}
