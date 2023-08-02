package com.inu.oauth2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class KakaoLoginRequestDto {
    private String authorizationCode;
}
