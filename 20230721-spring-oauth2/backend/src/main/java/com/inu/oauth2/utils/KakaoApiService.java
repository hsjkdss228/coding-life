package com.inu.oauth2.utils;

import com.inu.oauth2.dtos.KakaoOAuthAccessTokenDto;
import com.inu.oauth2.dtos.KakaoUserProfileDto;
import com.inu.oauth2.exceptions.KakaoRequestAccessTokenFailed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoApiService {
    private final String clientId;
    private final String redirectUrl;
    private final RestTemplate restTemplate;

    public KakaoApiService(@Value("${kakao.clientId}") String clientId,
                           @Value("${kakao.redirectUrl}") String redirectUrl,
                           RestTemplate restTemplate) {
        this.clientId = clientId;
        this.redirectUrl = redirectUrl;
        this.restTemplate = restTemplate;
    }

    public String requestAccessToken(String authorizationCode) {
        String url = "https://kauth.kakao.com/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("client_id", clientId);
        formData.add("redirect_url", redirectUrl);
        formData.add("code", authorizationCode);

        HttpEntity<MultiValueMap<String, String>> request
            = new HttpEntity<>(formData, headers);

        ResponseEntity<KakaoOAuthAccessTokenDto> response = restTemplate
            .exchange(
                url,
                HttpMethod.POST,
                request,
                KakaoOAuthAccessTokenDto.class
            );

        String accessToken = response.getBody().getAccessToken();

        if (!response.getStatusCode().is2xxSuccessful()
            || accessToken == null) {
            throw new KakaoRequestAccessTokenFailed();
        }

        return accessToken;
    }

    public KakaoUserProfileDto requestUserProfile(String accessToken) {
        String url = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<KakaoUserProfileDto> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            request,
            KakaoUserProfileDto.class
        );

        return response.getBody();
    }
}
