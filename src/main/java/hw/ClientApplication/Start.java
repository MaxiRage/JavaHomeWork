package hw.ClientApplication;

import hw.Core.Customer;
import hw.Interfaces.ICustomer;
import hw.Models.Ticket;

import java.util.Date;
import java.util.List;

public class Start extends EnterData {
    private ICustomer customer;
    private int ticketRouteNumber;
    private Date ticketDate;

    public void runLoginRegisterMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Покупка билетов");
            printMessageLine("Для входа\t\t\t\tнажмите 1\nДля регистрации\t\t\tнажмите 2\nДля выхода\t\t\t\tнажмите 0");
            System.out.print("Введите цифру > ");
            int choice;
            try {
                choice = inputInt(0, 2);
            } catch (RuntimeException ex) {
                System.err.println(ex.getMessage());
                continue;
            }
            System.out.println("=====================================================================================");
            run = runLoginRegisterMenuChoiceLogic(choice);
        }
    }

    private boolean runLoginRegisterMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1 -> login();
            case 2 -> register();
            default -> {
                return false;
            }
        }
        return true;
    }

    private void login() {
        printMessageLine("Авторизация");
        System.out.print("Ваше имя: ");
        String userName = inputString();
        System.out.print("Пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.println("=====================================================================================");
        System.out.print("Вход в систему... ");
        customer = new Customer();
        try {
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            System.out.println("Полундра....ошибка....");
            System.out.println(ex.getMessage());
            System.out.println("=====================================================================================");
            return;
        }
        printMessageLine("OK");
    }

    private void register() {
        printMessageLine("Регистрация");
        System.out.print("Введите имя для входа: ");
        String userName = inputString();
        System.out.print("Введите пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Повторите пароль: ");
        int passwordHash2 = inputString().hashCode();
        if (passwordHash != passwordHash2) {
            System.out.println("=====================================================================================");
            printMessageLine("Эммм...пароли не совпали. Регистрация!");
            return;
        }
        System.out.print("Введите номер карты (только цифры): ");
        long cardNumber = inputLong();
        System.out.println("=====================================================================================");
        System.out.print("Регистрация в системе ... ");
        customer = new Customer();
        int id;
        try {
            id = customer.getUserProvider().createClient(userName, passwordHash, cardNumber);
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            System.out.println("Полундра....ошибка....");
            System.out.println(ex.getMessage());
            System.out.println("=====================================================================================");
            return;
        }
        printMessageLine("OK. Пользователь " + customer.getUser().userName() + " с идентификатором " + id + " добавлен в базу");
    }

    private void runBuyingMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Заявка на покупку билетов | Пользователь " + customer.getUser().userName() + " |");
            printMessageLine("Чтобы выбрать номер маршрута и распечатать все билеты \tвведите 1\n" +
                    "Для выхода\t\t\t\t\t\t\t\t\t\tнажмите 0");
            System.out.print("Введите Ваш выбор > ");
            int choice;
            try {
                choice = inputInt(0, 1);
            } catch (RuntimeException ex) {
                System.out.println("==============================================================================" +
                        "=======");
                printMessageLine(ex.getMessage());
                continue;
            }
            System.out.println("=====================================================================================");
            run = runBuyingMenuChoiceLogic(choice);
        }
    }

    private boolean runBuyingMenuChoiceLogic(int choice) {
        if (choice == 1) {
            ticketRouteNumber = runSelectRouteMenu();
            if (ticketRouteNumber > 0) {
                ticketDate = runSelectDate();
                if (ticketDate != null) {
                    try {
                        customer.setSelectedTickets(customer.searchTicket(ticketDate, ticketRouteNumber));
                    } catch (RuntimeException ex) {
                        printMessageLine(ex.getMessage());
                        return true;
                    }
                    printAllTickets(customer.getSelectedTickets());
                    buyTicketMenu();
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private int runSelectRouteMenu() {
        printMessageLine("Введите номер маршрута и дату | Пользователь " + customer.getUser().userName() + " |");
        System.out.print("Номер маршрута > ");
        int numRoute;
        try {
            numRoute = inputInt(1, 2);
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return -1;
        }
        System.out.println("=====================================================================================");
        return numRoute;
    }

    private Date runSelectDate() {
        System.out.print("Дата (формат: YYYY-MM-DD) > ");
        Date date;
        try {
            date = inputDate();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return null;
        }
        System.out.println("=====================================================================================");
        return date;
    }

    private void printAllTickets(List<Ticket> ticks) {
        for (var t : ticks) {
            System.out.println(t.toString());
        }
        System.out.println("=====================================================================================");
    }

    private void buyTicketMenu() {
        printMessageLine("Подтвердите покупку | Пользователь " + customer.getUser().userName() + " |");
        System.out.print("Купить билет на автобусный маршрут " + ticketRouteNumber + " на " + ticketDate + " нажмите" +
                " \"Да\" > ");
        String answer = inputString();
        System.out.println("=====================================================================================");
        buyTicketMenuConfirmLogic(answer);
    }

    private void buyTicketMenuConfirmLogic(String answer) {
        if (answer.equalsIgnoreCase("Да")) {
            for (var t : customer.getSelectedTickets()) {
                if (t.getDate().equals(ticketDate) && t.getRouteNumber() == ticketRouteNumber && t.getValid()) {
                    boolean flag;
                    try {
                        flag = customer.buyTicket(t);
                    } catch (RuntimeException ex) {
                        printMessageLine(ex.getMessage());
                        return;
                    }
                    if (flag) {
                        printMessageLine(t.toPrint());
                        return;
                    }
                }
            }
        }
    }

    private void printMessageLine(String message) {
        System.out.println(message);
        System.out.println("=====================================================================================");
    }
}
