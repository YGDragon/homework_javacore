package workshop5.task_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {
    public static void main(String[] args) {
        /*
         * задание относительных путей
         * папки с исходными файлами
         * папки для резервной копии файлов
         */
        String sourceFolderPath = "src/main/java/workshop5/task_1/test_files";
        String destinationFolderPath = "src/main/java/workshop5/task_1/backup";
        createBackUpFiles(sourceFolderPath, destinationFolderPath);
    }

    public static void createBackUpFiles(String sourceFolderPath, String destinationFolderPath) {
        /*
         * определение дополнительного идентификатора даты и времени
         * для добавления к имени папки backup
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH'h'_mm'm'_ss's'");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        destinationFolderPath += dateFormat.format(timestamp) + "/";
        /* получение списка исходных файлов */
        File folder = new File(sourceFolderPath);
        File[] folderFiles = folder.listFiles();
        try {
            /* создание папки для размещения резервной копий файлов */
            Files.createDirectory(Paths.get(destinationFolderPath));
            /* копирование исходных файлов */
            for (File file : folderFiles) {
                Path sourcePath = file.toPath();
                Path targetPath = Paths.get(destinationFolderPath + file.getName());
                Files.copy(sourcePath, targetPath, REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(timestamp + " создана резервная копия файлов папки " + folder.getName());
        }
    }
}
