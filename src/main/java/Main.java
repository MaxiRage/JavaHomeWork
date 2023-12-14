import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[]{
                new Cat("Кот", 3, "Черный"),
                new Dog("Лаффи", 13, "Цверг"),
                new Cat("Локи", 3, "Коричневый"),
                new Dog("Елисей", 14, "Шнауцер")
        };

        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            System.out.println("Кличка: " + animal.name);
            System.out.println("Возраст: " + animal.age);

            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);
            } catch (Exception e) {
                System.out.println("Метод 'makeSound()' не найден.");
            }
            System.out.println();
        }
    }
}