package com.inu.event.services;

import com.inu.event.dtos.GameNameModificationRequestDto;
import com.inu.event.exceptions.GameNotFound;
import com.inu.event.models.Game;
import com.inu.event.repositories.GameRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModifyGameNameService {
    private final GameRepository gameRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ModifyGameNameService(GameRepository gameRepository,
                                 ApplicationEventPublisher eventPublisher) {
        this.gameRepository = gameRepository;
        this.eventPublisher = eventPublisher;
    }

    public void modifyGameName(
        Long gameId,
        GameNameModificationRequestDto gameNameModificationRequestDto
    ) {
        Game game = gameRepository.findById(gameId)
            .orElseThrow(GameNotFound::new);

        String previousName = game.name();
        game.changeName(gameNameModificationRequestDto.getName());

        eventPublisher.publishEvent(
            game.toGameNameModificationEvent(previousName)
        );
    }
}
