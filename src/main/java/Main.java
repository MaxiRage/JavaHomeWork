import lombok.SneakyThrows;

import java.io.File;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        String rootFolder = "C:\\Users\\iaros\\Documents\\MEGA\\Учёба\\Java\\Study\\GB\\12Java";
//        Backup.createBackupWithSubDir(rootFolder, rootFolder);
        Backup.createBackupWithOutSubDir(rootFolder);
        Tree.print(new File(rootFolder), "", true);
    }
}