import { Navigate, Route, Routes } from 'react-router-dom';

import LoginPage from './pages/LoginPage';
import OAuthPage from './pages/OAuthPage';
import ProfilePage from './pages/ProfilePage';

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/oauth" element={<OAuthPage />} />
      <Route path="/profile" element={<ProfilePage />} />
    </Routes>
  );
}
