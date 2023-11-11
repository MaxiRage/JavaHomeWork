package hw2;

import java.util.Random;

public class Server implements ServerListener {
    private final Random rand = new Random();
    private boolean status;
    private final BaseListener serverListener;

    public Server(BaseListener serverListener) {
        this.status = false;
        this.serverListener = serverListener;
    }

    public void start() {
        String msg;
        if (rand.nextBoolean() | rand.nextBoolean()) {
            if (status)
                msg = "Сервер уже запущен";
            else {
                status = true;
                msg = "Сервер запущен.";
            }
        } else
            msg = "Сервер не отвечает";
        serverListener.generateMessage(msg);
    }

    public void stop() {
        String msg;
        if (rand.nextBoolean() | rand.nextBoolean()) {
            if (status) {
                status = false;
                msg = "Сервер запущен";
            } else
                msg = "Сервер уже запущен";
        } else
            msg = "Сервер не отвечает";
        serverListener.generateMessage(msg);
    }
}