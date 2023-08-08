package workshop5.task_2;

import workshop5.task_2.class_item.Cell;

import java.util.Locale;
import java.util.Scanner;

public class View {

    public static void messageGameExit() {
        System.out.println("===> игр закончена".toUpperCase(Locale.ROOT));
    }

    public static void messageTextField() {
        System.out.println(" ".repeat(2) + "поле игры");
    }

    public static void messageMenu() {
        System.out.println(" ".repeat(16) + "меню игры");
        System.out.println("=".repeat(43));
        int i = 0; // итератор номера пунктов меню
        System.out.printf(
                ++i + ". Поставить символ в свободной ячейке поля" + "%n" +
                        ++i + ". Очистить игровое поле" + "%n" +
                        ++i + ". Выход из игры" + "%n");
        System.out.print("===> сделать ход  -> ".toUpperCase(Locale.ROOT));
    }

    public static void messageCellNumber() {
        System.out.print("ввведи номер пустой ячейки от 1 до 9 -> ".toUpperCase(Locale.ROOT));
    }

    public static void messageSymbol() {
        System.out.print("ввведи символ: X, 0, R -> ".toUpperCase(Locale.ROOT));
    }

    public static void errorNoEmptyCell() {
        System.out.println("ERROR===> ячейка занята!");
        System.out.println();
    }

    public static void errorMenuMessage() {
        System.out.println("ERROR===> ошибка ввода пункта меню!");
    }

    public static void errorCellMessage() {
        System.out.println("ERROR===> ошибка ввода номера ячейки!");
        System.out.println();
    }

    public static void errorSymbolMessage() {
        System.out.println("ERROR===> ошибка ввода символа!");
        System.out.println();
    }

    public static int getMenuItem() {
        int parseMenuNumber;
        String menuNumber = new Scanner(System.in).nextLine();
        try {
            parseMenuNumber = Integer.parseInt(menuNumber);
        } catch (NumberFormatException e) {
            return -1;
        }
        return parseMenuNumber;
    }

    public static Integer getCellNumber() {
        int parseCellNumber;
        String cellNumber = new Scanner(System.in).nextLine();
        try {
            int test = Integer.parseInt(cellNumber);
            if (test > 0 && test < 10) {
                parseCellNumber = test;
            } else {
                errorCellMessage();
                return null;
            }
        } catch (NumberFormatException e) {
            errorCellMessage();
            return null;
        }
        // postfix для удобства восприятия пользователем номера ячейки
        int postfix = 1;
        return parseCellNumber - postfix;
    }

    public static Integer getSymbol() {
        String symbol = new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT);
        try {
            if (symbol.equals(Cell.state[1])) {
                return 1;
            } else if (symbol.equals(Cell.state[2])) {
                return 2;
            } else if (symbol.equals(Cell.state[3])) {
                return 3;
            } else {
                errorSymbolMessage();
                return null;
            }
        } catch (NumberFormatException e) {
            errorSymbolMessage();
            return null;
        }
    }

    public static void printField(Cell[] dataField) {
        int i = -1;
        System.out.printf(
                "+---+---+---+" + "%n" +
                        "| " + dataField[++i] +
                        " | " + dataField[++i] +
                        " | " + dataField[++i] + " |" + "%n" +
                        "+---+---+---+" + "%n" +
                        "| " + dataField[++i] +
                        " | " + dataField[++i] +
                        " | " + dataField[++i] + " |" + "%n" +
                        "+---+---+---+" + "%n" +
                        "| " + dataField[++i] +
                        " | " + dataField[++i] +
                        " | " + dataField[++i] + " |" + "%n" +
                        "+---+---+---+" + "%n");
    }
}
