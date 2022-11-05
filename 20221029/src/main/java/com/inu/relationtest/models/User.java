package com.inu.relationtest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "PERSON")
public class User {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(mappedBy = "author")
  private List<Post> writtenPosts = new ArrayList<>();

  public User() {

  }

  public User(String name) {
    this.name = name;
  }

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public User(String name, List<Post> posts) {
    this.name = name;
    this.writtenPosts = posts;
  }

  public Long id() {
    return id;
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    String posts = writtenPosts.stream()
        .map(Post::detail)
        .collect(Collectors.joining(", "));

    return "\"id\":\"" + id + "\", " +
        "\"name\":\"" + name + "\", " +
        "\"writtenPosts\":\"" + posts + "\"";
  }
}
