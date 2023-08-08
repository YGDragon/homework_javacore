package workshop5.task_2;

import workshop5.task_2.class_item.Cell;

import static workshop5.task_2.View.*;
import static workshop5.task_2.Model.*;

public class GameX0 {

    public static void main(String[] args) {
        /* задание относительного файла игры */
        String filePath = "src/main/java/workshop5/task_2/game_resources/games_data.txt";
        Cell[] gamesField = Model.createCellArray(9);
        writeDataToFile(filePath, gamesField);
        while (true) {
            messageTextField();
            printField(gamesField);
            messageMenu();
            int menuItem = getMenuItem();
            switch (menuItem) {
                case 1 -> {
                    // получение номера ячейки
                    String dataRead = readDataFromFile(filePath);
                    messageCellNumber();
                    Integer cellNumber = getCellNumber();
                    if (cellNumber != null) {
                        if (checkOnEmptyCell(dataRead, cellNumber)) {
                            // получение символа для записи в ячейку
                            messageSymbol();
                            Integer symbol = getSymbol();
                            if (symbol != null) {
                                gamesField[cellNumber].setCurrentState(symbol);
                                writeDataToFile(filePath, gamesField);
                            }
                        } else {
                            errorNoEmptyCell();
                        }
                    }
                }
                case 2 -> {
                    gamesField = Model.createCellArray(9);
                    writeDataToFile(filePath, gamesField);
                }
                case 3 -> {
                    // выход из программы
                    messageGameExit();
                    System.exit(0);
                }
                default -> errorMenuMessage();
            }
        }
    }
}
