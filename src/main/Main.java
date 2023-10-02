public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add("item_1");
        list.add("item_2");
        list.add("item_3");
        list.add("item_4");

        list.add(1, "item_new");
        list.add(4, "item_new_2");

        list.forEach(System.out::println);
    }
}