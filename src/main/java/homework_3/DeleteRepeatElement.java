package homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Пройти по списку и удалить повторяющиеся элементы
 */

public class DeleteRepeatElement {

    public static void main(String[] args) {
        List<String> planets = new ArrayList<>();
        Random rand = new Random();
        String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        for (int i = 0; i < 10; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        System.out.println(planets);
        System.out.println(planets.stream().distinct().collect(Collectors.toList()));
    }
}
