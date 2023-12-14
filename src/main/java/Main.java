import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        List<Integer> listInt = List.of(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//        List<Integer> listInt = List.of(1, 5, -1, 3, 5, 23); // проверка списка без четных чисел

        OptionalDouble aver = listInt.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();

        if (aver.isPresent()) {
            System.out.println("Среднее всех четных чисел: " + aver.getAsDouble());
        } else {
            System.out.println("Четных чисел нет");
        }
    }
}