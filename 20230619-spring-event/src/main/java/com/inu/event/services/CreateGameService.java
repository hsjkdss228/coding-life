package com.inu.event.services;

import com.inu.event.dtos.GameCreationRequestDto;
import com.inu.event.models.Game;
import com.inu.event.repositories.GameRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateGameService {
    private final GameRepository gameRepository;
    private final ApplicationEventPublisher eventPublisher;

    public CreateGameService(GameRepository gameRepository,
                             ApplicationEventPublisher eventPublisher) {
        this.gameRepository = gameRepository;
        this.eventPublisher = eventPublisher;
    }

    public String createGame(GameCreationRequestDto gameCreationRequestDto) {
        String name = gameCreationRequestDto.getName();
        Game game = new Game(name);
        Game savedGame = gameRepository.save(game);

        eventPublisher.publishEvent(game.toGameCreationEvent());

        return "생성된 Game Id: " + savedGame.id();
    }
}
