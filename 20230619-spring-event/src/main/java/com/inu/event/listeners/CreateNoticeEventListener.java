package com.inu.event.listeners;

import com.inu.event.events.GameCreationEvent;
import com.inu.event.events.GameNameModificationEvent;
import com.inu.event.services.CreateGameCreationNoticeService;
import com.inu.event.services.CreateGameNameModificationNoticeService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CreateNoticeEventListener {
    private final CreateGameCreationNoticeService createGameCreationNoticeService;
    private final CreateGameNameModificationNoticeService createGameNameModificationNoticeService;

    public CreateNoticeEventListener(
        CreateGameCreationNoticeService createGameCreationNoticeService,
        CreateGameNameModificationNoticeService createGameNameModificationNoticeService
    ) {
        this.createGameCreationNoticeService = createGameCreationNoticeService;
        this.createGameNameModificationNoticeService = createGameNameModificationNoticeService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(GameCreationEvent gameCreationEvent) {
        createGameCreationNoticeService
            .createGameCreationNotice(gameCreationEvent);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onApplicationEvent(GameNameModificationEvent gameNameModificationEvent) {
        createGameNameModificationNoticeService
            .createGameNameModificationNotice(gameNameModificationEvent);
    }
}
