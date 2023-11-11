package hw1;

import javax.swing.*;
import java.awt.*;

public class Connect extends JFrame {
    private static final int WINDOW_HEIGHT = 140;
    private static final int WINDOW_WIDTH = 520;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private final JTextField loginField = new JTextField("Введите ваш логин: ");

    public Connect() {
        JPanel grid = new JPanel(new GridLayout(4, 1));

        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Подключение к серверу");

        grid.add(loginField);
        grid.add(new JTextField("Введите ваш пароль: "));
        grid.add(new JTextField("Введите адрес сервера и порт для подключения: "));
        JButton buttonConnect = new JButton("Подключиться");
        grid.add(buttonConnect);

        add(grid);

        buttonConnect.addActionListener(e -> {
            String login = loginField.getText().replace("Введите ваш логин: ", "");
            new Chat(login);
        });
        setVisible(true);
    }


}