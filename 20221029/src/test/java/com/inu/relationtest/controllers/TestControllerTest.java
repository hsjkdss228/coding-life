package com.inu.relationtest.controllers;

import com.inu.relationtest.services.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

class TestControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TestService testService;

  @Test
  void postByUserId() {

  }
}
