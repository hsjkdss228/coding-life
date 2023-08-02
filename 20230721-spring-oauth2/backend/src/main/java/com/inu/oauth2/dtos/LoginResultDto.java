package com.inu.oauth2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResultDto {
    private String accessToken;
}
