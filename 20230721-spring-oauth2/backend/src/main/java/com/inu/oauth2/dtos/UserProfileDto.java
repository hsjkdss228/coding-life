package com.inu.oauth2.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserProfileDto {
    private String id;

    private String nickname;

    private String email;
}
