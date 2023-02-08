package homework_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

public class Employee {

    public static void main(String[] args) {

        List<String> employee = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

        new LinkedList<>(employee.stream()
                .map(temp -> temp.substring(0, temp.indexOf(" ")))
                .collect(toMap(key -> key, value -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .toList())
                .descendingIterator()
                .forEachRemaining(System.out::println);
    }
}
