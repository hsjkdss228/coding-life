package com.inu.relationtest.controllers;

import com.inu.relationtest.dtos.PostDto;
import com.inu.relationtest.models.Post;
import com.inu.relationtest.models.User;
import com.inu.relationtest.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
  private final TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/posts")
  public void posts() {
    List<Post> posts = testService.findAllPosts();

    System.out.println(posts);
  }

  @GetMapping("/users")
  public void users() {
    List<User> users = testService.findAllUsers();

    System.out.println(users);
  }

  @PostMapping("/post/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public String post(
      @PathVariable Long id
  ) {
    String detail = "압도적 승리감";

    Post post = testService.addPost(detail, id);

    System.out.println(post);

    return post.toString();
  }

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public String createUserWithPosts() {
    String name = "조성환";

    User user = testService.createUserWithPosts(name);

    System.out.println(user);

    return user.toString();
  }

  @GetMapping("/users/post/{postId}")
  public void usersByPostId(
      @PathVariable Long postId
  ) {
    List<User> usersByPostId = testService.findUsersByPostId(postId);

    System.out.println(usersByPostId);
  }

  @GetMapping("/post/user/{userId}")
  public PostDto postByUserId(
      @PathVariable Long userId
  ) {
    Post post = testService.findPostByUserId(userId);

    return post.toDto();
  }
}
