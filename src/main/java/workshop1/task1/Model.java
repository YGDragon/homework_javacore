package workshop1.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Model {

    Scanner in = new Scanner(System.in);
    private String fileName;
    static String fileExtension = ".txt";// расширение файла

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static void writeDataToFile(String fileName, String data) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName + fileExtension))) {
            bf.write(new Date() + " -> " + data.toUpperCase(Locale.ROOT));
            bf.newLine();
        } catch (Exception e) {
            System.out.println("ошибка записи в файла".toUpperCase(Locale.ROOT));
            System.out.println("повторите процедуру записи в файл.".toUpperCase(Locale.ROOT));
        }
    }

    public static void writeDataToFile(String fileName) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName + fileExtension))) {
            bf.write("");
        } catch (Exception e) {
            System.out.println("ошибка создания файла".toUpperCase(Locale.ROOT));
            System.out.println("повторите процедуру создания файла.".toUpperCase(Locale.ROOT));
        }
    }
}
