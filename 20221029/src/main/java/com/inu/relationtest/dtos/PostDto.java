package com.inu.relationtest.dtos;

public class PostDto {
  private final Long id;

  private final String detail;

  private final String author;

  public PostDto(Long id, String detail, String author) {
    this.id = id;
    this.detail = detail;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public String getDetail() {
    return detail;
  }

  public String getAuthor() {
    return author;
  }
}
