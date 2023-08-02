package com.inu.oauth2.controllers;

import com.inu.oauth2.applications.KakaoLoginService;
import com.inu.oauth2.dtos.KakaoLoginRequestDto;
import com.inu.oauth2.dtos.LoginResultDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    private final KakaoLoginService kakaoLoginService;

    public OAuthController(KakaoLoginService kakaoLoginService) {
        this.kakaoLoginService = kakaoLoginService;
    }

    @PostMapping("oauth/token")
    public LoginResultDto token(
        @RequestBody KakaoLoginRequestDto kakaoLoginRequestDto
    ) {
        String authorizationCode = kakaoLoginRequestDto.getAuthorizationCode();
        return kakaoLoginService.login(authorizationCode);
    }
}
