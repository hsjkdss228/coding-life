import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useLocalStorage } from 'usehooks-ts';

import useKakao from '../hooks/useKakao';

export default function LoginPage() {
  const [accessToken] = useLocalStorage('accessToken', '');

  const navigate = useNavigate();

  useEffect(() => {
    if (accessToken) {
      navigate('/profile');
    }
  }, []);

  const kakao = useKakao();

  const host = 'http://localhost:8080';

  const handleClickKakaoLoginButton = async () => {
    kakao.Auth.authorize({
      redirectUri: `${host}/oauth`,
    });
  };

  return (
    <div>
      <button
        type="button"
        onClick={handleClickKakaoLoginButton}
      >
        카카오 아이디로 로그인
      </button>
    </div>
  );
}
