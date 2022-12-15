package kr.megaptera.chattingpolling.services;

import kr.megaptera.chattingpolling.dtos.MessagesResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChattingService {
    List<String> messages = new ArrayList<>();

    public MessagesResponseDto getMessages() {
        return new MessagesResponseDto(messages);
    }

    public void inputMessage(String message) {
        messages.add(message);
    }
}
