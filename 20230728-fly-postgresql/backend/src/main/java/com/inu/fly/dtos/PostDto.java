package com.inu.fly.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostDto {
    private Long id;

    private String title;

    private String descriptionText;
}
