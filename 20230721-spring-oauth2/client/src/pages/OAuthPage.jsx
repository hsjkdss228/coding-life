import { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import { useLocalStorage } from 'usehooks-ts';

import { apiService } from '../services/ApiService';

export default function OAuthPage() {
  const [, setAccessToken] = useLocalStorage('accessToken', '');

  const { search } = useLocation();

  const queryParams = search.substring(1);

  if (queryParams.startsWith('error')) {
    return (
      <p>로그인을 취소했습니다.</p>
    );
  }

  const authorizationCode = queryParams.split('=')[1];

  const navigate = useNavigate();

  const requestAccessToken = async () => {
    const { accessToken } = await apiService.requestAccessToken(authorizationCode);

    const id = 2;

    if (accessToken) {
      setAccessToken(accessToken);
      apiService.setAccessToken(accessToken);
      navigate(`/profile/${id}`);
    }
  };

  useEffect(() => {
    requestAccessToken();
  }, []);

  return (
    <p>로그인을 진행하는 중입니다...</p>
  );
}
