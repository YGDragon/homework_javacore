package workshop1.task1;

public class Main {
    public static void main(String[] args) {

        /*
         * 1.Создать приложение с вложенностью пакетов не менее 3х,
         * где будет класс для входа и несколько классов с логикой.
         * Пример: приложение для внесения заметок во внешний файл с обязательной фиксацией времени.
         * пример:
         * Введите заметку: Hello, world!
         * Дозапись в файл: 16.07.2023 -> Hello, world
         * Скомпилируйте и запустите посредством CLI
         */
        Model model = new Model();
        View.welcomeMessage();
        View.fileNamedMessage();
        model.setFileName(model.in.nextLine());
        Model.writeDataToFile(model.getFileName());
        View.getDataMessage();
        Model.writeDataToFile(model.getFileName(), model.in.nextLine());
    }
}
