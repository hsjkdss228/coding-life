package com.inu.event.dtos;

public class GameNameModificationRequestDto {
    private String name;

    private GameNameModificationRequestDto() {

    }

    public GameNameModificationRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
