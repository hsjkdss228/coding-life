package kr.megaptera.chattingpolling.dtos;

import java.util.List;

public class MessagesResponseDto {
    private final List<String> messages;

    public MessagesResponseDto(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
