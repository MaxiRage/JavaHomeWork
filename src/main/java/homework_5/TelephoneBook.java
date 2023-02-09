package homework_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов
 */

public class TelephoneBook {
    public static Map<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        addInPhoneBook("Rage", List.of("981 981 98 19", "22-12-43", "+7(911)405-45-12"));
        addInPhoneBook("Maxi", List.of("981 981 98 19"));

        findBySurname("Rage");
    }

    public static void addInPhoneBook(String surname, List <String> number) {
        phoneBook.put(surname, number);
    }

    public static void findBySurname(String surname) {
        System.out.printf("%s: %s", surname, phoneBook.get(surname));
    }
}
