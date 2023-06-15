package exceptions_3.service.impl;

import exceptions_3.constants.Gender;
import exceptions_3.exceptions.ParseException;
import exceptions_3.exceptions.UserDataException;
import exceptions_3.model.User;
import exceptions_3.service.InputConsoleReader;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@AllArgsConstructor
public class InputConsoleReaderImpl implements InputConsoleReader {
    private final Scanner scanner;

    @Override
    public User readUserData() throws UserDataException {
        while (true) {
            System.out.println("������� ��������� ������, �������� ��������: ������� ��� �������� ���� �������� (dd.mm.yyyy) ����� �������� ��� (f ��� m)");

            try {
                String input = scanner.nextLine();
                String[] data = input.split(" ");

                if (data.length != 6) throw new UserDataException("������� �������� ���������� ������");

                LocalDate birthday = parseDateOfBirth(data[3]);
                long tel = parsePhoneNumber(data[4]);
                Gender gender = parseGender(data[5]);

                return User.builder()
                        .surname(data[0])
                        .name(data[1])
                        .middleName(data[2])
                        .birthday(birthday)
                        .tel(tel)
                        .gender(gender)
                        .build();
            } catch (ParseException | NumberFormatException e) {
                System.out.println("������: " + e.getMessage());
            }
        }
    }

    private LocalDate parseDateOfBirth(String dateOfBirthString) throws ParseException {
        try {
            return LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new ParseException("�������� ������ ���� ��������");
        }
    }

    private long parsePhoneNumber(String phoneNumberString) throws ParseException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new ParseException("�������� ������ ������ ��������");
        }
    }

    private Gender parseGender(String genderString) throws ParseException {
        if (genderString.equalsIgnoreCase("m")) {
            return Gender.MALE;
        } else if (genderString.equalsIgnoreCase("f")) {
            return Gender.FEMALE;
        } else {
            throw new ParseException("�������� ������ ����");
        }
    }
}
