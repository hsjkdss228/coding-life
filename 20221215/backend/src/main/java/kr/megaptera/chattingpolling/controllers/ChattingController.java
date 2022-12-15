package kr.megaptera.chattingpolling.controllers;

import kr.megaptera.chattingpolling.dtos.MessageRequestDto;
import kr.megaptera.chattingpolling.dtos.MessagesResponseDto;
import kr.megaptera.chattingpolling.services.ChattingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/chat")
public class ChattingController {
    private final ChattingService chattingService;

    public ChattingController(ChattingService chattingService) {
        this.chattingService = chattingService;
    }

    @GetMapping
    public MessagesResponseDto message() {
        System.out.println("요청이 들어옵니다...");

        return chattingService.getMessages();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void input(
        @RequestBody MessageRequestDto messageRequestDto
    ) {
        chattingService.inputMessage(messageRequestDto.getMessage());
    }
}
