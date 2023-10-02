package exceptions_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("¬ведите дробное число: ");
            try {
                if (reader.readLine().equals("exit"))
                    break;
                float num = Float.parseFloat(reader.readLine());
                System.out.printf("¬веденное число равно %.2f\n", num);
            } catch (IOException | NumberFormatException e) {
                System.out.println("ј вот теперь число, а не строку или зап€тую на точку помен€й:-)");
            }
        }
    }
}
