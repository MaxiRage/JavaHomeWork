package ru.example.rage.service;

import ru.example.rage.model.User;

public interface AuthService {

  void register(User user);
  void login(String username, String password);
  void logout(Long userId);
  User getCurrentUser(Long sessionId);
}
