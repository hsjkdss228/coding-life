package com.inu.oauth2.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class KakaoProfileDto {
    @JsonProperty("nickname")
    private String nickname;
}
