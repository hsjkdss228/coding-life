package com.inu.relationtest.repositories;

import com.inu.relationtest.models.Post;
import com.inu.relationtest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
  Optional<Post> findById(Long postId);

//  Post findByAuthor(User user);

  Post save(Post post);
}
