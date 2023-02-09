package homework_2;

/**
 * Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение)
 */
public class Palindrome {

    public static void main(String[] args) {
        String str = "Palindrome";
        String str2 = "Able was I ere I saw Elba";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
    }

    public static boolean isPalindrome(String check) {

        int left = 0;
        int right = check.length() - 1;

        while (left < right) {

            String leftChar = String.valueOf(check.charAt(left));
            String rightChar = String.valueOf(check.charAt(right));

            if (leftChar.equalsIgnoreCase(rightChar)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
