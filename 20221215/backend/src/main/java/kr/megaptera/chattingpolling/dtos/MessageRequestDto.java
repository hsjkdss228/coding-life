package kr.megaptera.chattingpolling.dtos;

public class MessageRequestDto {
    private String message;

    public MessageRequestDto() {

    }

    public MessageRequestDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
