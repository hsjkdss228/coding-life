package com.inu.oauth2.applications;

import com.inu.oauth2.dtos.KakaoUserProfileDto;
import com.inu.oauth2.dtos.UserProfileDto;
import com.inu.oauth2.utils.KakaoApiService;
import org.springframework.stereotype.Service;

@Service
public class GetUserProfileService {
    private final KakaoApiService kakaoApiService;

    public GetUserProfileService(KakaoApiService kakaoApiService) {
        this.kakaoApiService = kakaoApiService;
    }

    public UserProfileDto getUserProfile(String accessToken) {
        KakaoUserProfileDto kakaoUserProfileDto = kakaoApiService
            .requestUserProfile(accessToken);

        return UserProfileDto.builder()
            .id(kakaoUserProfileDto.getId())
            .nickname(kakaoUserProfileDto.getKakaoAccount().getKakaoProfile().getNickname())
            .email(kakaoUserProfileDto.getKakaoAccount().getEmail())
            .build();
    }
}
