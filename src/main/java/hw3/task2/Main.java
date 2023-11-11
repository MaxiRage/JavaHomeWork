package hw3.task2;

public class Main {
    public static void main(String[] args) {
        ArrayLengthComparison comparison = new ArrayLengthComparison();

        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {4, 5, 6};
        boolean res1 = comparison.compareArrays(arr1, arr2, true);
        System.out.println("Сравниваем массивы одинаковой длины и типов: " + res1);

        String[] arr3 = {"pineapple", "bananaaaaaa"};
        Integer[] arr4 = {1, 3, 5};
        boolean res2 = comparison.compareArrays(arr3, arr4, true);
        System.out.println("Сравниваем массивы разной длины и типов: " + res2);

        Integer[] arr5 = {1, 2, 3, 4};
        String[] arr6 = {"pineapple", "bananaaaaaa", "hot-cherry"};
        boolean res3 = comparison.compareArrays(arr5, arr6, false);
        System.out.println("Сравниваем массивы разной длины без проверки типов: " + res3);

        Integer[] arr7 = {};
        String[] arr8 = {};
        boolean res4 = comparison.compareArrays(arr7, arr8, true);
        System.out.println("Сравниваем пустые массивы: " + res4);

        Integer[] arr9 = {1, 2, 3};
        Object[] arr10 = {"pineapple", 2, "hot-cherry"};
        boolean res5 = comparison.compareArrays(arr9, arr10, true);
        System.out.println("Сравниваем массивы разных типов в одном из них: " + res5);
    }
}