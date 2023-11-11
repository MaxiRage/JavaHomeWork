package hw2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Chat(new ConsoleServerListener(), new Server(new LogServerListener("logs.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}