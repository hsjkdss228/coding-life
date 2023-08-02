package com.inu.oauth2.exceptions;

public class KakaoRequestAccessTokenFailed extends RuntimeException {
    public KakaoRequestAccessTokenFailed() {
        super("카카오 Access Token 획득 요청에 실패했습니다.");
    }
}
