import { messageService } from '../services/MessageService';

const baseUrl = 'ws://localhost:8002';

export default class MessageStore {
  constructor() {
    this.listeners = new Set();

    this.userIndex = Math.ceil(Math.random() * 1000);

    this.socket = '';
    this.connected = false;

    this.currentRoomIndex = 0;
    this.roomIndices = [1, 2, 3];

    this.messageToSend = '';

    this.messageLogs = [];
  }

  connect(roomIndex) {
    this.socket = new WebSocket(`${baseUrl}/chat/rooms/${roomIndex}`);

    this.currentRoomIndex = roomIndex;
    this.connected = true;
    this.publish();
  }

  disconnect() {
    this.sendMessage({ status: 'DISCONNECTED' });

    this.socket.close();

    this.connected = false;
    this.currentRoomIndex = 0;
    this.messageLogs = [];
    this.publish();
  }

  changeInput(value) {
    this.messageToSend = value;
    this.publish();
  }

  sendMessage({ status }) {
    if (status === 'CONNECTED') {
      this.messageToSend = `사용자 ${this.userIndex} 님이 채팅방 ${this.currentRoomIndex}에 입장했습니다.`;
    }

    if (status === 'DISCONNECTED') {
      this.messageToSend = `사용자 ${this.userIndex} 님이 채팅방 ${this.currentRoomIndex}에서 나갔습니다.`;
    }

    if (status === 'SEND') {
      this.messageToSend = `사용자 ${this.userIndex}: ${this.messageToSend}`;
    }

    messageService.sendMessage({
      socket: this.socket,
      messageToSend: this.messageToSend,
    });

    this.messageToSend = '';
    this.publish();
  }

  receiveMessage(message) {
    this.messageLogs = [...this.messageLogs, message];
    this.publish();
  }

  subscribe(listener) {
    this.listeners.add(listener);
  }

  unsubscribe(listener) {
    this.listeners.delete(listener);
  }

  publish() {
    this.listeners.forEach((listener) => listener());
  }
}

export const messageStore = new MessageStore();
