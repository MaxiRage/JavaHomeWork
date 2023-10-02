package exceptions_1;

//–еализуйте 3 метода, чтобы в каждом из них получить разные исключени€
public class Task1 {
    public static void main(String[] args) {
        String[] list = {"value", null, "value3"};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        try {
            division(10, 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            try {
                printStringArray(list);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
                try {
                    printValueByIndex(array, 12);
                } catch (ArrayIndexOutOfBoundsException exc) {
                    System.out.println(exc.getMessage());
                }
            }
        }

    }

    // division by zero
    public static void division(int firstNum, int secondNum) {
        if (secondNum == 0) throw new ArithmeticException("Exception: Ќа ноль делить нельз€");
        int result = firstNum / secondNum;
        System.out.println("ќшибок нет: " + result);
    }

    // Index out of bounds
    public static void printValueByIndex(int[] array, int index) {
        if (index > array.length - 1)
            throw new ArrayIndexOutOfBoundsException("Exception: Ёлемента под таким индексом не существует");
        else System.out.printf("Ёлемент с индексом %d равен %d.\n", index, array[index]);
    }

    // NPE
    public static void printStringArray(String[] list) {
        for (String item : list) {
            if (item == null) throw new NullPointerException("Exception: Ёлемент отсутствует");
            System.out.println(item);
        }
    }
}
