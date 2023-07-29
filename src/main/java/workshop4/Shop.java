package workshop4;

import workshop4.entity_classes.Costumer;
import workshop4.entity_classes.Order;
import workshop4.entity_classes.Product;
import workshop4.model_view_service.Service;
import workshop4.model_view_service.View;

import java.util.Locale;

public class Shop {
    public static void main(String[] args) {
        int sizeOrders = 5;
        Costumer[] costumers = {
                new Costumer("Иванов Иван Иванович", 31, "375295127601"),
                new Costumer("Петров Петр Петрович", 26, "375332318813")
        };
        Product[] products = {
                new Product("Шуруповерт Bosh", 200),
                new Product("Строительный пылесос Kerher", 350),
                new Product("Электролобзик Makita", 280),
                new Product("Набор бит Bosh", 50),
                new Product("Перфоратор Wortex", 310)
        };
        Order[] orders = new Order[sizeOrders];
        int countOrder = 0;
        while (true) {
            switch (View.selectActionMenu()) {
                case ("1") -> View.printAllProducts(products);
                case ("2") -> {
                    Order newOrder = Service.makeAnOrder(
                            View.getCostumerName(), View.getCostumerAge(), View.getCostumerPhone(),
                            View.getProductTitle(), View.getProductPrice(),
                            View.getProductAmount(),
                            costumers, products);
                    if (newOrder != null) {
                        orders[countOrder] = newOrder;
                        countOrder++;
                    }
                    if (countOrder == sizeOrders) {
                        System.out.println("превышен лимит заказов!".toUpperCase(Locale.ROOT));
                        View.printAllOrders(orders);
                        return;
                    }
                }
                case ("3") -> View.printAllOrders(orders);
                default -> {
                    View.exitMessage();
                    System.exit(0);
                }
            }
        }
    }
}
