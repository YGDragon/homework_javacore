package workshop5.task_2;

import workshop5.task_2.class_item.Cell;

import java.io.*;

public class Model {

    public static Cell[] createCellArray(int size) {
        Cell[] data = new Cell[9];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Cell();
        }
        return data;
    }

    public static void writeDataToFile(String filePath, Cell[] dataField) {
        try (FileWriter out = new FileWriter(filePath)) {
            for (Cell cell : dataField
            ) {
                String data = String.valueOf(cell.getCurrentState());
                out.write(data);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDataFromFile(String filePath) {
        StringBuilder data = new StringBuilder();
        try (FileReader fr = new FileReader(filePath)) {
            int i = fr.read();
            while (i != -1) {
                data.append(((char) i));
                i = fr.read();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static boolean checkOnEmptyCell(String dataField, int cellNumber) {
        return dataField.charAt(cellNumber) == '0';
    }
}
