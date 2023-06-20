package com.inu.event.events;

public class GameNameModificationEvent {
    private final Long gameId;

    private final String previousName;

    public GameNameModificationEvent(Long gameId,
                                     String previousName) {
        this.gameId = gameId;
        this.previousName = previousName;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getPreviousName() {
        return previousName;
    }
}
