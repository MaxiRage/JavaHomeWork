package hw.ClientApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class EnterData {

    protected int inputInt(int minVariant, int maxVariant) throws RuntimeException {
        int num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextInt();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Это не цифра...");
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка ... пу-пу-пу....");
        }
        if (num < minVariant || num > maxVariant) {
            throw new RuntimeException("Вы ввели недопустимое значение");
        }
        return num;
    }

    protected long inputLong() throws RuntimeException {
        long num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextLong();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("This is not number.");
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (num < (long) 1 || num > (long) Integer.MAX_VALUE) {
            throw new RuntimeException("You entered an invalid value.");
        }
        return num;
    }

    protected String inputString() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        String str;
        try {
            str = in.next();
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("You must something enter");
        }
        return str;
    }

    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Scanner in = new Scanner(System.in);
        String str;
        Date date;
        try {
            str = in.nextLine();
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("You must something enter");
        }
        try {
            date = ft.parse(str);
        } catch (ParseException ex) {
            throw new RuntimeException("You must enter date");
        }
        return date;
    }
}
