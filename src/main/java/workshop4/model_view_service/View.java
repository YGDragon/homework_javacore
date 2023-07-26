package workshop4.model_view_service;

import java.util.Locale;
import java.util.Scanner;

public class View {
    public Scanner enterData = new Scanner(System.in);

    public void menuMessage() {
        System.out.println("меню магазина".toUpperCase(Locale.ROOT));
        System.out.printf(
                "1. Совершить покупку" + "%n" +
                        "2. " + "%n");
    }
}
