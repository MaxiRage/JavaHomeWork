package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationImpl implements FileOperation {

    private final String fileName;

    public FileOperationImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readText() {
        List<String> lines = new ArrayList<>();
        String result;
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = String.join("\n", lines);

        return result;
    }

    @Override
    public void saveText(String text) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
