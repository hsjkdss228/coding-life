package com.inu.relationtest.models;

import com.inu.relationtest.dtos.PostDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {
  @Id
  @GeneratedValue
  private Long id;

  private String detail;

  @ManyToOne
  @JoinColumn(name = "PERSON_ID")
  private User author;

  public Post() {

  }

  public Post(Long id, String detail, User user) {
    this.id = id;
    this.detail = detail;
    this.author = user;
  }

  public Post(Long id, String detail) {
    this.id = id;
    this.detail = detail;
  }

  public Post(String detail, User user) {
    this.detail = detail;
    this.author = user;
  }

  public String detail() {
    return detail;
  }

  @Override
  public String toString() {
    return "\"id\":\"" + id + "\", " +
        "\"detail\":\"" + detail + "\", " +
        "\"author\":\"" + author.name() + "\"";
  }

  public PostDto toDto() {
    return new PostDto(
        id,
        detail,
        author.name()
    );
  }
}
