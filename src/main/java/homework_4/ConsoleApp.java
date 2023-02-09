package homework_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Реализовать консольное приложение, которое:
 * Принимает от пользователя и “запоминает” строки.
 * Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
 * Если введено revert, удаляет предыдущую введенную строку из памяти.
 */
public class ConsoleApp {

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String textUser = reader.readLine();

            if (textUser.equals("print")) {
                list.stream()
                        .sorted(Collections.reverseOrder())
                        .forEach(System.out::println);
            } else if (textUser.equals("revert")) {
                list.remove(list.size()-1);
            } else list.add(textUser);
        }
    }
}
