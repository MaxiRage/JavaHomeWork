package controllers;

import lombok.AllArgsConstructor;
import model.Fields;
import model.User;
import repository.Repository;
import utils.Validate;

import java.util.List;

@AllArgsConstructor
public class UserController {
    private final Repository repository;
    private final Validate validate;

    public void saveUser(User user) throws Exception {
        validate.checkNumber(user.getPhone());
        repository.createUser(user);
    }
    public void updateUser(User user, Fields field, String param) throws Exception {
        if(field == Fields.PHONE) {
            validate.checkNumber(param);
        }
        repository.updateUser(user, field, param);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("Пользователь не найден");
    }
    public List <User> getUsers() {
        return repository.getAllUsers();
    }
    public void deleteUser(User user) {
        repository.deleteUser(user);}
}
