package com.inu.event.services;

import com.inu.event.events.GameCreationEvent;
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
public class CreateGameCreationNoticeService {
    private final GameRepository gameRepository;
    private final NoticeRepository noticeRepository;

    public CreateGameCreationNoticeService(GameRepository gameRepository,
                                           NoticeRepository noticeRepository) {
        this.gameRepository = gameRepository;
        this.noticeRepository = noticeRepository;
    }

    public void createGameCreationNotice(GameCreationEvent gameCreationEvent) {
        Game game = gameRepository
            .findById(gameCreationEvent.getGameId())
            .orElseThrow(GameNotFound::new);

        String content = game.name() + " 게임이 생성되었습니다.";
        Notice notice = new Notice(content);
        noticeRepository.save(notice);
    }
}
