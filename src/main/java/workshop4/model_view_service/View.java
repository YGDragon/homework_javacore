package workshop4.model_view_service;

import workshop4.entity_classes.Order;
import workshop4.entity_classes.Product;

import java.util.Locale;
import java.util.Scanner;

public class View {
    public static final String[] DATA = {
            "ФИО",//0
            "Возраст: лет",//1
            "Номер телефона: 12 цифр",//2
            "Наименование товара",//3
            "Цена товара",//4
            "Количество товара"//5
    };
    public static final String ERROR = "некорректный ввод данных -> ".toUpperCase(Locale.ROOT);

    public static void exitMessage() {
        System.out.println("приложение остановлено".toUpperCase(Locale.ROOT));
    }

    public static void menuMessage() {
        System.out.println("меню магазина".toUpperCase(Locale.ROOT));
        System.out.printf(
                "0. Выход из приложения" + "%n" +
                        "1. Показать товары магазина" + "%n" +
                        "2. Совершить покупку" + "%n" +
                        "3. Показать все заказы" + "%n");
    }

    public static String selectActionMenu() {
        menuMessage();
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();
        for (int i = 0; i < result.length(); i++) {
            if (!Character.isDigit(result.charAt(i))) {
                System.out.printf("действие не выбрано ->%n");
                selectActionMenu();
                break;
            }
        }
        return result;
    }

    public static void printAllProducts(Product[] products) {
        System.out.println("товары в магазине".toUpperCase(Locale.ROOT));
        System.out.println("*".repeat(30));
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();
    }

    public static void printAllOrders(Order[] orders) {
        System.out.println("*".repeat(30));
        System.out.println("заказы в магазине:".toUpperCase(Locale.ROOT));
        for (Order order : orders) {
            if (order != null) System.out.println(order);
        }
        System.out.println();
    }

    public static String getCostumerName() {//ввод и проверка данных ФИО
        System.out.print(DATA[0] + " -> ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                System.out.println(ERROR + DATA[0] + " (введено " + name + ")");
            }
        }
        return name;
    }

    public static String getCostumerAge() {//ввод и проверка данных возраста
        System.out.print(DATA[1] + " -> ");
        String age = new Scanner(System.in).nextLine();
        try {
            int ageParse = Integer.parseInt(age);
            if (ageParse < 18) {
                System.out.println(ERROR + DATA[1] + " (введено " + age + ")");
                return "0";
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR + DATA[1] + " (введено " + age + ")");
            return "0";
        }
        return age;
    }

    public static String getCostumerPhone() {//ввод и проверка данных номера телефона
        System.out.print(DATA[2] + " -> ");
        String phone = new Scanner(System.in).nextLine();
        if (phone.length() != 12) {
            System.out.println(ERROR + DATA[2] + " (введено " + phone.length() + ")");
            return "000000000000";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println(ERROR + DATA[2] + " (введено " + phone + ")");
                return "000000000000";
            }
        }
        return phone;
    }

    public static String getProductTitle() {//ввод и проверка данных наименования товара
        System.out.print(DATA[3] + " -> ");
        String title = new Scanner(System.in).nextLine();
        if (title.isEmpty()) return " --- ";
        return title;
    }

    public static String getProductPrice() {//ввод и проверка данных цены товара
        System.out.print(DATA[4] + " -> ");
        String price = new Scanner(System.in).nextLine();
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + DATA[4] + " (введено " + price + ")");
            return "0";
        }
        return price;
    }

    public static String getProductAmount() {//ввод и проверка данных количества
        System.out.print(DATA[5] + " -> ");
        String amount = new Scanner(System.in).nextLine();
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + DATA[5] + " (введено " + amount + ")");
            return "0";
        }
        return amount;
    }
}