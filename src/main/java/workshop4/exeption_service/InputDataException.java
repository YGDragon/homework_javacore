package workshop4.exeption_service;

public class InputDataException extends RuntimeException {

    public InputDataException(String message) {
        super("Некорректный ввод данных -> " + message);
    }
}
