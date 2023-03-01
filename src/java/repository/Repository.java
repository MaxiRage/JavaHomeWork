package repository;

import model.Fields;
import model.User;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user, Fields field, String param);

    void deleteUser(User user);
}
