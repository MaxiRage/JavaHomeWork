package exceptions_3;

import exceptions_3.exceptions.UserDataException;
import exceptions_3.model.User;
import exceptions_3.service.FileWriter;
import exceptions_3.service.impl.FileWriterImpl;
import exceptions_3.service.impl.InputConsoleReaderImpl;
import exceptions_3.service.InputConsoleReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            InputConsoleReader inputReader = new InputConsoleReaderImpl(scanner);
            FileWriter fileWriter = new FileWriterImpl();

            try {
                User user = inputReader.readUserData();
                fileWriter.writeUserData(user);
            } catch (UserDataException | IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println("Еще запишем? нажми \"n\" для выхода или \"enter\" для продолжения");
            scanner = new Scanner(System.in);
            if(scanner.nextLine().equalsIgnoreCase("n")) break;
        }
    }
}
