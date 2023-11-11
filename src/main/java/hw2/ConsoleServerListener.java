package hw2;

public class ConsoleServerListener implements BaseListener {

    @Override
    public void generateMessage(String msg) {
        System.out.println(msg);
    }
}