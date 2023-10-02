import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {

    public static void createBackupWithSubDir(String rootDir, String copyDir) throws IOException {
        File backupDir = new File("./backup");
        if (!backupDir.exists())
            backupDir.mkdir();
        else backupDir = new File(copyDir);

        File sourceDir = new File(rootDir);
        File[] filesToBackup = sourceDir.listFiles();

        if (filesToBackup != null)
            for (File file : filesToBackup)
                if (file.isFile())
                    Files.copy(file.toPath(), new File(backupDir.getPath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                else if (file.isDirectory()) {
                    File newDir = new File(backupDir.getPath() + "/" + file.getName());
                    if (!newDir.exists())
                        newDir.mkdir();

                    createBackupWithSubDir(String.valueOf(file.toPath()), newDir.getPath());
                }
    }

    public static void createBackupWithOutSubDir(String rootDir) throws IOException {
        File backupDir = new File("./backup");
        if (!backupDir.exists())
            backupDir.mkdir();

        File sourceDir = new File(rootDir);
        File[] filesToBackup = sourceDir.listFiles();

        if (filesToBackup != null)
            for (File file : filesToBackup)
                if (file.isFile())
                    Files.copy(file.toPath(), new File(backupDir.getPath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                else if (file.isDirectory())
                    createBackupWithOutSubDir(String.valueOf(file.toPath()));
    }
}
