package hw.ClientApplication;

import hw.Core.UserProvider;
import hw.Models.User;

public class Authentication {

    public static User authentication(UserProvider userProvider, String login, int passHash) {
        var client = userProvider.getClientByName(login);
        if (client.hashPassword() == passHash) {
            return client;
        } else {
            throw new RuntimeException("Полундра.....Ошибка аутентификации");
        }
    }
}
