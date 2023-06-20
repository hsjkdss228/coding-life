package com.inu.event.services;

import com.inu.event.events.GameNameModificationEvent;
import com.inu.event.exceptions.GameNotFound;
import com.inu.event.models.Game;
import com.inu.event.models.Notice;
import com.inu.event.repositories.GameRepository;
import com.inu.event.repositories.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CreateGameNameModificationNoticeService {
    private final GameRepository gameRepository;
    private final NoticeRepository noticeRepository;

    public CreateGameNameModificationNoticeService(GameRepository gameRepository,
                                                   NoticeRepository noticeRepository) {
        this.gameRepository = gameRepository;
        this.noticeRepository = noticeRepository;
    }

    public void createGameNameModificationNotice(
        GameNameModificationEvent gameNameModificationEvent
    ) {
        Game game = gameRepository
            .findById(gameNameModificationEvent.getGameId())
            .orElseThrow(GameNotFound::new);

        String content =
            gameNameModificationEvent.getPreviousName() + " 게임 이름이 " +
                game.name() + " 이름으로 변경되었습니다.";
        Notice notice = new Notice(content);
        noticeRepository.save(notice);
    }
}
