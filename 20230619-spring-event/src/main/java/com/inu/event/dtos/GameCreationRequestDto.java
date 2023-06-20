package com.inu.event.dtos;

public class GameCreationRequestDto {
    private String name;

    private GameCreationRequestDto() {

    }

    public GameCreationRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
