package exceptions_3.service.impl;

import exceptions_3.model.User;
import exceptions_3.service.FileWriter;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeUserData(User user) throws IOException {
        String fileName = user.getSurname() + ".txt";
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName, true)) {
            String userDataString = String.join(" ",
                    user.getSurname(),
                    user.getName(),
                    user.getMiddleName(),
                    user.getBirthday().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    String.valueOf(user.getTel()),
                    user.getGender().toString());
            writer.write(userDataString + "\n");
        }
        System.out.println("Данные успешно записаны в файл: " + fileName);
    }
}
