package com.inu.oauth2.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class KakaoAccountDto {
    @JsonProperty("profile")
    private KakaoProfileDto kakaoProfile;

    @JsonProperty("email")
    private String email;
}
