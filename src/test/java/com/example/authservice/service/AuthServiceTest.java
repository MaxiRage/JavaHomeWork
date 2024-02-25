package com.example.authservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.example.rage.model.User;
import ru.example.rage.model.UserSession;
import ru.example.rage.repository.UserRepository;
import ru.example.rage.repository.UserSessionRepository;
import ru.example.rage.service.AuthServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserSessionRepository userSessionRepository;

  @InjectMocks
  private AuthServiceImpl authService;

  @Test
  public void testRegister() {
    User user = new User();
    authService.register(user);
    verify(userRepository).save(user);
  }

  @Test
  public void testLogin() {
    String username = "testUser";
    String password = "testPassword";
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    when(userRepository.findByUsername(username)).thenReturn(user);
    authService.login(username, password);
    verify(userSessionRepository).save(any(UserSession.class));
  }

  @Test
  public void testLogout() {
    Long userId = 1L;
    authService.logout(userId);
    verify(userSessionRepository).deleteById(userId);
  }
}