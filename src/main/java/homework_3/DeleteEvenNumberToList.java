package homework_3;

import java.util.ArrayList;
import java.util.List;

/***
 * Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
 */

public class DeleteEvenNumberToList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(12, 11, 232, 12, 94, 21, 0, 213, 4565, 13, 76, 1, 2, 3, 8));

        list.removeIf(integer -> integer % 2 == 0);

        System.out.println(list);
    }
}
