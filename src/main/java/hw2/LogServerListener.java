package hw2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;


public class LogServerListener implements BaseListener {

    private final File logFile;

    public LogServerListener(String filename) throws IOException {
        logFile = new File(filename);
        if (!logFile.exists())
            logFile.createNewFile();
    }

    @Override
    public void generateMessage(String msg) {
        msg = LocalDateTime.now() + " " + msg;
        try (BufferedReader tempReader = new BufferedReader(new FileReader(this.logFile))) {
            List<String> lines = (tempReader.lines().toList());
            BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.logFile));
            for (String line : lines) {
                fileStream.append(line);
                fileStream.newLine();
            }
            fileStream.write(msg);
            fileStream.newLine();
            fileStream.flush();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}