package workshop3.task1;

import java.util.Locale;
import java.util.Scanner;

public class View {
    public int selectActionMenu() {
        Scanner in = new Scanner(System.in);
        return Integer.parseInt(in.nextLine());
    }

    public void menuMessage() {
        System.out.printf("%n" + "меню программы:".toUpperCase(Locale.ROOT) + "%n" +
                "0." + "Выход из программы" + "%n" +
                "1." + "Вывод данных о всех сотрудниках" + "%n" +
                "2." + "Повышение зарплаты сотрудникам методом1" + "%n" +
                "3." + "Повышение зарплаты сотрудникам методом2" + "%n" +
                "4." + "Вывод средней зарплаты сотрудников" + "%n" +
                "5." + "Вывод среднего возраста сотрудников" + "%n");
    }

    public void salaryAverageMessage(double avg) {
        System.out.println("Средняя зарплата сотрудников равна " + avg + " рублей");
    }

    public void ageAverageMessage(double avg) {
        System.out.println("Средний возраст сотрудников равен " + avg + " лет");
    }
}
