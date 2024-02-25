package ru.example.rage.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSession  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private Long userId;
  @Column
  private String username;
  @Column
  private String password;

  public void setLoggedInAt(LocalDateTime now) {
  }
}
