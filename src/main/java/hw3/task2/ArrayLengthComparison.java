package hw3.task2;

public class ArrayLengthComparison {

    public <T> boolean compareArrays(T[] arr, T[] arr2, boolean checkElementType) {
        boolean check = areAllElementsOfSameType(arr) && areAllElementsOfSameType(arr2);
        if (checkElementType && !check)
            return false;
        return arr.length == arr2.length;
    }

    public boolean areAllElementsOfSameType(Object[] arr) {
        if (arr == null || arr.length == 0)
            return true;
        Class<?> elementType = arr[0].getClass();

        for (Object element : arr)
            if (element == null || !element.getClass().equals(elementType))
                return false;

        return true;
    }
}