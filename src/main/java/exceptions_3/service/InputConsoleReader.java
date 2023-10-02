package exceptions_3.service;

import exceptions_3.exceptions.UserDataException;
import exceptions_3.model.User;

public interface InputConsoleReader {

    User readUserData() throws UserDataException;
}
