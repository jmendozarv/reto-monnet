package com.challenger.users.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.challenger.users.config.JwtService;
import com.challenger.users.dto.LoginRequest;
import com.challenger.users.dto.LoginResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias de AuthController")
class AuthControllerTest {

  @Mock
  private JwtService jwtService;

  @InjectMocks
  private AuthController authController;

  @Test
  @DisplayName("Debe retornar 200 y token cuando credenciales son validas")
  void login_returnsTokenForValidCredentials() {
    LoginRequest request = new LoginRequest("admin", "admin123");
    when(jwtService.generateToken("admin")).thenReturn("token-mock");

    ResponseEntity<LoginResponse> response = authController.login(request);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("token-mock", response.getBody().token());
    verify(jwtService).generateToken("admin");
  }

  @Test
  @DisplayName("Debe retornar 401 cuando credenciales son invalidas")
  void login_returnsUnauthorizedForInvalidCredentials() {
    LoginRequest request = new LoginRequest("admin", "bad-password");

    ResponseEntity<LoginResponse> response = authController.login(request);

    assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    assertNull(response.getBody());
    verifyNoInteractions(jwtService);
  }
}

