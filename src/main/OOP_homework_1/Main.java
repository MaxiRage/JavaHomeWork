package OOP_homework_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo zoopark = new Zoo();
        zoopark.addAnimals(List.of(
//                new Cat("Barsik")
//                , new Dog("Sharik")
//                , new Rabbit("Whik"), new Cow("Murka")
//                , new Duck("Krya")
//                , new Butterfly("Yellow")
                new Pinguin("Dori")
        ));

        for (Sayable animal : zoopark.getSayAble()) {
            System.out.println(animal.say());
        }

        System.out.println("---------------------------------------------");
        for (Swimming animal : zoopark.getSwimming()) {
            System.out.println(animal);
        }


//        System.out.println("---------------------------------------------");
//        for (Runable item : zoopark.getRunable()) {
//            System.out.println(item);
//        }
//        System.out.println("---------------------------------------------");
//        for (Flyable item : zoopark.getFlyable()) {
//            System.out.println(item);
//        }
//        System.out.println("---------------------------------------------");
//        System.out.println(zoopark.getWinner());
//
//        System.out.println("---------------------------------------------");
//        System.out.println(zoopark.getWinnerFly());
    }
}
