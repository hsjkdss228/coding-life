package com.inu.oauth2.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class KakaoUserProfileDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccountDto kakaoAccount;
}
