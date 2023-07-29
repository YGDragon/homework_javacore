package workshop4.model_view_service;

import workshop4.entity_classes.Costumer;
import workshop4.entity_classes.Order;
import workshop4.entity_classes.Product;
import workshop4.exeption_service.AmountException;
import workshop4.exeption_service.CostumerException;
import workshop4.exeption_service.ProductException;

import java.util.Locale;
import java.util.Objects;

public class Service {

    public static Order makeAnOrder(
            String name, String age, String phone,
            String title, String price,
            String amount,
            Costumer[] costumers, Product[] products) {
        int ageParse = Integer.parseInt(age);
        int amountParse = Integer.parseInt(amount);
        int priceParse = Integer.parseInt(price);
        try {
            int countP = 0;
            for (Product product : products
            ) {
                if (Objects.equals(product, new Product(title, priceParse))) countP++;
            }
            if (countP == 0) throw new ProductException();
            if (amountParse < 1 || amountParse > 50) throw new AmountException();
            int countC = 0;
            for (Costumer costumer : costumers
            ) {
                if (Objects.equals(costumer, new Costumer(name, ageParse, phone))) countC++;
            }
            if (countC == 0) throw new CostumerException();
        } catch (ProductException e) {
            e.errorMessage();
            return null;
         } catch (AmountException e) {
            return new Order(
                    new Costumer(name, ageParse, phone),
                    new Product(title, priceParse),
                    e.getOne());
        } catch (CostumerException e) {
            throw new RuntimeException("приложение остановлено -> ".toUpperCase(Locale.ROOT) +
                    "был передан неверный пользователь");
        }
        return new Order(
                new Costumer(name, ageParse, phone),
                new Product(title, priceParse),
                amountParse);
    }
}
