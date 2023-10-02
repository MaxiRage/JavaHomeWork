package exceptions_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("������� �����: ");
        try {
            String result = reader.readLine();
            if(result.isBlank())
                throw new RuntimeException("������ ������ ������� ������");
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
