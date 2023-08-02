/* eslint-disable class-methods-use-this */

import axios from 'axios';

const apiBaseUrl = 'http://localhost:8000';

export default class ApiService {
  constructor() {
    this.accessToken = '';
  }

  setAccessToken(accessToken) {
    this.accessToken = accessToken;
  }

  async requestAccessToken(authorizationCode) {
    const { data } = await axios.post(
      `${apiBaseUrl}/oauth/token`,
      { authorizationCode },
    );
    return data;
  }

  async fetchProfile() {
    const { data } = await axios.get(
      `${apiBaseUrl}/me/profile`,
      {
        headers: {
          Authorization: `Bearer ${this.accessToken}`,
        },
      },
    );
    return data;
  }
}

export const apiService = new ApiService();
