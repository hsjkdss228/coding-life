package com.inu.event.events;

public class GameCreationEvent {
    private final Long gameId;

    public GameCreationEvent(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }
}
