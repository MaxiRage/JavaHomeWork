package ru.example.rage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.rage.model.UserSession;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
}
