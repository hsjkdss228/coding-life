package com.inu.oauth2.applications;

import com.inu.oauth2.dtos.LoginResultDto;
import com.inu.oauth2.utils.KakaoApiService;
import org.springframework.stereotype.Service;

@Service
public class KakaoLoginService {
    private final KakaoApiService kakaoApiService;

    public KakaoLoginService(KakaoApiService kakaoApiService) {
        this.kakaoApiService = kakaoApiService;
    }

    public LoginResultDto login(String authorizationCode) {
        String accessToken = kakaoApiService.requestAccessToken(authorizationCode);

        return new LoginResultDto(accessToken);
    }
}
