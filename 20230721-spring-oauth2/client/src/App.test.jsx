import { render } from '@testing-library/react';

import { MemoryRouter } from 'react-router-dom';

import App from './App';

describe('App', () => {
  it('App.jsx를 렌더링', () => {
    render((
      <MemoryRouter>
        <App />
      </MemoryRouter>
    ));
  });
});
