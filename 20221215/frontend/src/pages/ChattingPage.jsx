import { useState } from 'react';
import axios from 'axios';
import useInterval from 'use-interval';

const apiBaseUrl = 'http://localhost:8001';

const userIndex = Math.ceil(Math.random() * 100);

export default function ChattingPage() {
  const [inputMessage, setInputMessage] = useState('');
  const [chattingLogs, setChattingLogs] = useState([]);

  useInterval(async () => {
    const { data } = await axios.get(`${apiBaseUrl}/chat`);

    const isChanged = data.messages.length !== chattingLogs.length;
    if (isChanged) {
      setChattingLogs(data.messages);
    }
  }, 1000);

  const handleChangeInput = (event) => {
    const { value } = event.target;
    setInputMessage(value);
  };

  const handleClickSendMessage = async () => {
    const messageToSend = {
      message: `사용자 ${userIndex}: ${inputMessage}`,
    };
    await axios.post(`${apiBaseUrl}/chat`, messageToSend);
  };

  return (
    <div>
      <p>
        사용자 id:
        {' '}
        {userIndex}
      </p>
      <label htmlFor="input-message">
        메시지 입력
      </label>
      <input
        id="input-message"
        type="text"
        value={inputMessage}
        onChange={(event) => handleChangeInput(event)}
      />
      <button
        type="button"
        onClick={handleClickSendMessage}
      >
        전송
      </button>
      {chattingLogs.length === 0 ? (
        <p>전송된 메시지가 없습니다.</p>
      ) : (
        <ul>
          {chattingLogs.map((message) => (
            <li key={message}>
              {message}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
