package exceptions_3.service;

import exceptions_3.model.User;

import java.io.IOException;

public interface FileWriter {
    void writeUserData(User user) throws IOException;

}
