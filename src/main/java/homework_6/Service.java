package homework_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {

    public static void start(List<NoteBook> allNotebook) {

        System.out.println(hint());

        exit:
        while (true) {
            try {
                switch (Service.inputTextUser().toLowerCase(Locale.ROOT)) {
                    case "all" -> allNotebook.forEach(System.out::println);
                    case "minprice" -> System.out.println(Service.filterByMinPrice(allNotebook));
                    case "maxprice" -> System.out.println(Service.filterByMaxPrice(allNotebook));
                    case "filterprice" -> {
                        while (true) {
                            try {
                                List<NoteBook> filterList = Service.filterByPrice(allNotebook, Double.parseDouble(Service.inputTextUser()));
                                if (filterList.isEmpty()) {
                                    System.out.println("Не найдено ноутбуков по данному фильтру. Запросите команду заново :) \n" +
                                            "Самый дешевый нотубук:");
                                    System.out.println(Service.filterByMinPrice(allNotebook).getPrice());
                                } else filterList.forEach(System.out::println);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Введите корректную цену");
                            }
                        }
                    }
                    case "color" -> System.out.println(Service.allColor(allNotebook));
                    case "hint" -> System.out.println(Service.hint());
                    case "exit" -> {
                        break exit;
                    }
                    default -> System.out.println(Service.hint());
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода");
                System.out.println(Service.hint());
            }
        }
    }

    public static List<NoteBook> filterByPrice(List<NoteBook> listNotebook, double maxFilterPrice) {
        return listNotebook.stream()
                .filter(noteBook -> noteBook.getPrice() < maxFilterPrice)
                .toList();
    }

    public static NoteBook filterByMinPrice(List<NoteBook> listNotebook) {
        return listNotebook.stream()
                .min(NoteBook::compare)
                .get();
    }

    public static NoteBook filterByMaxPrice(List<NoteBook> listNotebook) {
        return listNotebook.stream()
                .max(NoteBook::compare)
                .get();
    }

    public static Set<String> allColor(List<NoteBook> listNotebook) {
        return listNotebook.stream()
                .map(noteBook -> noteBook.color)
                .collect(Collectors.toSet());
    }

    public static String hint() {
        return """
                Для вывода списка ноутбуков используйте следующие команды:
                "all" - вывести все ноутбуки
                "minPrice" - вывести самый дешевый ноутбук
                "maxPrice" - вывести самый дорогой ноутбук
                "filterPrice" - фильтр по максимальной цене, введите ее после этой команды
                "color" - вывести цвета, которые есть в наличии
                "hint" - вывести снова эту подсказки
                "exit" - для выхода из магазина
                """;
    }

    public static String inputTextUser() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            return "Ошибка ввода";
        }
    }
}