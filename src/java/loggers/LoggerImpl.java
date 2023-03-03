package loggers;

import java.io.FileWriter;
import java.io.IOException;

public class LoggerImpl implements Logger {

    private final String fileName;

    public LoggerImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void log(String text) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
