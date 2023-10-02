import java.io.File;

public class Tree {
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─ ");
            indent += "  ";
        } else {
            System.out.print("├─ ");
            indent += "│ ";
        }

        if (file.isDirectory()) {
            System.out.println(file.getName() + "/");
        } else {
            System.out.println(file.getName());
            return;
        }

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        int subDirTotal = 0, fileTotal = 0, subDirCounter = 0, fileCounter = 0;

        for (File value : files) {
            if (value.isDirectory())
                subDirTotal++;
            else
                fileTotal++;
        }

        for (File value : files) {
            if (value.isDirectory()) {
                print(value, indent, subDirCounter == subDirTotal - 1 && fileCounter == fileTotal);
                subDirCounter++;
            } else {
                print(value, indent, fileCounter == fileTotal - 1 && subDirCounter == subDirTotal);
                fileCounter++;
            }
        }
    }
}