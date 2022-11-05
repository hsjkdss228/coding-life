package com.inu.relationtest.services;

import com.inu.relationtest.exceptions.PostNotFound;
import com.inu.relationtest.exceptions.UserNotFound;
import com.inu.relationtest.models.Post;
import com.inu.relationtest.models.User;
import com.inu.relationtest.repositories.PostRepository;
import com.inu.relationtest.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  public TestService(PostRepository postRepository,
                     UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  public List<Post> findAllPosts() {
    return postRepository.findAll();
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public Post findPostByUserId(Long userId) {
    return null;
  }

  public Post addPost(String detail, Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(UserNotFound::new);

    Post post = new Post(detail, user);

    return postRepository.save(post);
  }

  public User createUserWithPosts(String name) {
    User user = new User(name);

    User createdUser = userRepository.save(user);

    List<Post> posts = List.of(
        new Post(10L, "압", createdUser),
        new Post(11L, "압도", createdUser)
    );

    postRepository.saveAll(posts);

    return userRepository.findById(createdUser.id())
        .orElseThrow(UserNotFound::new);
  }

  public List<User> findUsersByPostId(Long postId) {
//    Post post = postRepository.findById(postId)
//        .orElseThrow(PostNotFound::new);
//
//    return userRepository.findByWrittenPost(post);
  }
}
