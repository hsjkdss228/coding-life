package com.inu.event.controllers;

import com.inu.event.dtos.GameCreationRequestDto;
import com.inu.event.dtos.GameNameModificationRequestDto;
import com.inu.event.exceptions.GameNotFound;
import com.inu.event.services.CreateGameService;
import com.inu.event.services.ModifyGameNameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("games")
public class GameController {
    private final CreateGameService createGameService;
    private final ModifyGameNameService modifygameNameService;

    public GameController(CreateGameService createGameService,
                          ModifyGameNameService modifygameNameService) {
        this.createGameService = createGameService;
        this.modifygameNameService = modifygameNameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String gameCreation(
        @RequestBody GameCreationRequestDto gameCreationRequestDto
    ) {
        return createGameService.createGame(gameCreationRequestDto);
    }

    @PatchMapping("{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void gameNameModification(
        @PathVariable("gameId") Long gameId,
        @RequestBody GameNameModificationRequestDto gameNameModificationRequestDto
    ) {
        modifygameNameService.modifyGameName(
            gameId,
            gameNameModificationRequestDto
        );
    }

    @ExceptionHandler(GameNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String gameNotFound(RuntimeException exception) {
        return exception.getMessage();
    }
}
