package hw2;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame implements ClientListener {

    private final BaseListener listener;

    public Chat(BaseListener listener, Server server) {
        this.listener = listener;
        setBounds(100, 300, 360, 240);

        JPanel grid = new JPanel(new GridLayout(1, 2));
        JButton btnStart = new JButton("Старт");
        grid.add(btnStart);
        JButton btnStop = new JButton("Стоп");
        grid.add(btnStop);

        btnStart.addActionListener(e -> {
            server.start();
            event("Запуск сервера");
        });

        btnStop.addActionListener(e -> {
            server.stop();
            event("Остановка сервера");
        });

        add(grid);
        setVisible(true);
    }

    @Override
    public void event(String msg) {
        listener.generateMessage(msg);
    }
}