package hw1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 440;
    private static final int WINDOW_WIDTH = 520;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private final String LOG_PATH = "log.txt";
    private final JTextArea textOutput = new JTextArea("");
    private final JTextField textInput = new JTextField();

    public Chat(String login) {
        JPanel grid = new JPanel(new GridLayout(4, 1));

        logRecovery();

        setTitle("Чат с сервером");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        textOutput.setEditable(false);
        textOutput.setBackground(Color.GRAY);
        grid.add(textOutput);
        grid.add(textInput);
        grid.add(new JLabel("Введите сообщение серверу: "));
        JButton buttonConnect = new JButton("Отправить");
        grid.add(buttonConnect);

        buttonConnect.addActionListener(e -> {
            String logMessage = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd MMM yy")) + " " + login + " : " + textInput.getText() + "\n";
            writerLog(logMessage);
            textOutput.append(logMessage);
        });

        getRootPane().setDefaultButton(buttonConnect);

        add(grid);
        setVisible(true);
    }

    public void writerLog(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void logRecovery() {
        new JTextArea().setEditable(false);

        String logFileName = LOG_PATH;
        if (fileExists(logFileName))
            loadChatHistory(logFileName);
    }

    public boolean fileExists(String fileName) {
        return new File((fileName)).exists();
    }

    private void loadChatHistory(String logFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                textOutput.append(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}