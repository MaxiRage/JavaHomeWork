import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int count = 1000;

        Map<Integer, Boolean> res = new HashMap<>();

        for (int i = 1; i <= count; i++) {
            int prizeDoor = random.nextInt(3);
            int initChoice = random.nextInt(3);

            int doorToReveal = getDoorToReveal(random, prizeDoor, initChoice);
            getFinalChoice(random, initChoice, doorToReveal);

            boolean winWithoutSwitch = initChoice == prizeDoor;
            res.put(i, winWithoutSwitch);
        }

        int positiveResults = (int) res.values()
                .stream()
                .filter(result -> result)
                .count();

        int negativeRes = count - positiveResults;

        double percentPositive = (double) positiveResults / count * 100;
        double percentNegative = (double) negativeRes / count * 100;

        System.out.println("Положительные результаты: " + positiveResults);
        System.out.println("Отрицательные результаты: " + negativeRes);
        System.out.printf("Процент положительных результатов: %.2f%%\n", percentPositive);
        System.out.printf("Процент отрицательных результатов: %.2f%%\n", percentNegative);
    }

    private static int getDoorToReveal(Random random, int prizeDoor, int initialChoice) {
        int doorToReveal;
        do {
            doorToReveal = random.nextInt(3);
        } while (doorToReveal == prizeDoor || doorToReveal == initialChoice);
        return doorToReveal;
    }

    private static void getFinalChoice(Random random, int initialChoice, int doorToReveal) {
        int finalChoice;
        do {
            finalChoice = random.nextInt(3);
        } while (finalChoice == initialChoice || finalChoice == doorToReveal);
    }
}