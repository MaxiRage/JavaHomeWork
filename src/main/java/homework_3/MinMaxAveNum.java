package homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
 */

public class MinMaxAveNum {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(12, 11, 232, 12, 94, 21, 0, 213, 4565, 13, 76, 1, 2, 3, 8));

        Integer max = list.stream().reduce(Integer::max).get();
        Integer min = list.stream().reduce(Integer::min).get();
        OptionalDouble average = list.stream().mapToInt(e -> e).average();

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.printf("average = %.2f", average.getAsDouble());
    }
}
