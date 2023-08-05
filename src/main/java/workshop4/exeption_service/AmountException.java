package workshop4.exeption_service;

import java.util.Locale;

public class AmountException extends RuntimeException {
    public int getOne() {
        System.out.println();
        System.out.println("передано малое или слишком большое значение количества!".toUpperCase(Locale.ROOT));
        return 1;
    }
}