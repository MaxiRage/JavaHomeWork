package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public enum User {;

    public enum Request {;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class UserDTO {
            String name;
            String password;
        }
    }

    public enum Response {;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class RegistrationDTO {
            String name;
            LocalDateTime timeRegistration;
            String role;
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDTO {
        String name;
        String lastName;
    }
}
