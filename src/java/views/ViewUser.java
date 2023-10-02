package views;

import controllers.UserController;
import exception.PhoneException;
import lombok.AllArgsConstructor;
import model.Fields;
import model.User;
import utils.Validate;

import java.util.Arrays;
import java.util.Scanner;

@AllArgsConstructor
public class ViewUser {

    private final UserController userController;
    private final Validate validate;

    public void run() {
        Commands com;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE -> create();
                    case READ -> read();
                    case UPDATE -> update();
                    case LIST -> list();
                    case DELETE -> delete();
                    case HELP -> showHelp();
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка: " + ex.getMessage());
                showHelp();
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        User user = userController.readUser(id);
        System.out.println(user);
    }

    private void update() throws Exception {
        String userId = prompt("Введите id пользователя: ");
        String fieldName = prompt("Введите что меняем: NAME, SURNAME или PHONE ");
        String param;
        if (Fields.valueOf(fieldName) == Fields.PHONE) {
            param = catchTelephone();
            if (param == null) {
                return;
            }
        } else {
            param = prompt("На что меняем?: ");
        }
        User user = userController.readUser(userId);
        userController.updateUser(user, Fields.valueOf(fieldName.toUpperCase()), param);
    }

    public String catchTelephone() throws Exception {
        while (true) {
            try {
                String telephone = prompt("Введите номер телефона c +7 (Для выхода 0): ");
                if (telephone.equals("0")) {
                    return null;
                }
                validate.checkNumber(telephone);
                return telephone;
            } catch (PhoneException ex) {
                System.out.println("Произошла ошибка: " + ex.getMessage());
            }
        }
    }

    private void list() {

        for (User user : userController.getUsers()) {
            System.out.println(user);
        }
    }

    private void create() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone;
        phone = catchTelephone();
        if (phone == null) {
            return;
        }

        userController.saveUser(
                User.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .phone(phone)
                        .build());
    }

    private void delete() throws Exception {
        String userid = prompt("Введите ID пользователя, которого хотите удалить: ");
        User user = userController.readUser(userid);
        userController.deleteUser(user);
    }

    private void showHelp() {
        System.out.println("Список команд: ");
        Arrays.stream(Commands.values()).forEach(System.out::println);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}