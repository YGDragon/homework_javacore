package workshop4.exeption_service;

import java.util.Locale;

public class ProductException extends RuntimeException {
    public void errorMessage() {
        System.out.print("ошибка".toUpperCase(Locale.ROOT) + " -> не совершать данную покупку");
    }
}