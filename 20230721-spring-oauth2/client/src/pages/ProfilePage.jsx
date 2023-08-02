import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useLocalStorage } from 'usehooks-ts';
import { apiService } from '../services/ApiService';

export default function ProfilePage() {
  const [accessToken, setAccessToken] = useLocalStorage('accessToken', '');

  const navigate = useNavigate();

  const [profile, setProfile] = useState(null);

  const fetchProfile = async () => {
    if (!accessToken) {
      navigate('/login');
    }

    if (accessToken) {
      const data = await apiService.fetchProfile();
      setProfile(data);
    }
  };

  useEffect(() => {
    fetchProfile();
  }, []);

  const handleClickLogoutButton = () => {
    setAccessToken('');
    setProfile(null);
    navigate('/login');
  };

  if (!profile) {
    return (
      <p>프로필을 조회하고 있습니다...</p>
    );
  }

  return (
    <div>
      <p>
        {`닉네임: ${profile.nickname}`}
      </p>
      <p>
        {`이메일: ${profile.email}`}
      </p>
      <button
        type="button"
        onClick={handleClickLogoutButton}
      >
        로그아웃
      </button>
    </div>
  );
}
