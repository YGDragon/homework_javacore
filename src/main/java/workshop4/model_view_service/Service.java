package workshop4.model_view_service;

import workshop4.entity_classes.Costumer;
import workshop4.entity_classes.Order;
import workshop4.entity_classes.Product;
import workshop4.exeption_service.InputDataException;

import java.util.Locale;

public class Service {
    public static Order buyProduct(
            String name, String ageBuyer, String phoneNumberBuyer,
            String title, String price,
            String amountProduct) {
        int age, amount;
        long phoneNumber;
        try {
            age = Integer.parseInt(ageBuyer);
        } catch (NumberFormatException e) {
            throw new InputDataException("возраст покупателя");
        }
        try {
            amount = Integer.parseInt(ageBuyer);
        } catch (NumberFormatException e) {
            throw new InputDataException("количество товара");
        }
        try {
            phoneNumber = Integer.parseInt(phoneNumberBuyer);
        } catch (NumberFormatException e) {
            throw new InputDataException("номер телефона");
        }
        System.out.println("заказ успешно оформлен".toUpperCase(Locale.ROOT));
        return new Order(
                new Costumer(name, age, phoneNumber),
                new Product(title, price),
                amount);
    }
}