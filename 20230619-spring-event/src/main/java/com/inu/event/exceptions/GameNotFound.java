package com.inu.event.exceptions;

public class GameNotFound extends RuntimeException {
    public GameNotFound() {
        super("존재하지 않는 게임입니다.");
    }
}
