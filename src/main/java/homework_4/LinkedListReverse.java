package homework_4;

import java.util.LinkedList;
import java.util.List;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */

public class LinkedListReverse {

    public static void main(String[] args) {
        System.out.println(reverseLinkedList(new LinkedList<>(List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"))));
    }

    private static LinkedList<String> reverseLinkedList(LinkedList<String> linkedList) {
        int temp = 0;

        while (temp != linkedList.size() - 1) {
            linkedList.add(linkedList.size() - temp, linkedList.getFirst());
            linkedList.removeFirst();
            temp++;
        }
        return linkedList;
    }
}
