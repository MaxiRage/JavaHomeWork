package homework_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * �������� �����, ������� �������� ������, ��������� �� 100 ���������� ����� TEST
 * � �����, ������� ������� ��� ������ � ������� ��������� ����, ����������� ����������
 */

public class SaveTestToFile {

    public static void main(String[] args) {

        String word = "TEST";

        recordStringToFile(repeat100Word(word));

    }

    public static String repeat100Word(String word) {
        return word.repeat(100);
    }

    public static void recordStringToFile(String text) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/homework_2/test.txt")) {
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
