/* eslint-disable class-methods-use-this */

export default class MessageService {
  sendMessage({
    socket,
    messageToSend,
  }) {
    socket.send(messageToSend);
  }
}

export const messageService = new MessageService();
