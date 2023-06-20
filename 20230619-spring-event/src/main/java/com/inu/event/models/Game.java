package com.inu.event.models;

import com.inu.event.events.GameCreationEvent;
import com.inu.event.events.GameNameModificationEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Game() {

    }

    public Game(String name) {
        this.name = name;
    }

    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public void changeName(String modifiedName) {
        this.name = modifiedName;
    }

    public GameCreationEvent toGameCreationEvent() {
        return new GameCreationEvent(id);
    }

    public GameNameModificationEvent toGameNameModificationEvent(String previousName) {
        return new GameNameModificationEvent(id, previousName);
    }
}
