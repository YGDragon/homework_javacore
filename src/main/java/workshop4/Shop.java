package workshop4;

import workshop4.entity_classes.Costumer;
import workshop4.entity_classes.Order;
import workshop4.entity_classes.Product;

public class Shop {
    public static void main(String[] args) {
        int orderSizeArray = 5;
        Costumer[] costumers = {
                new Costumer("Иванов Иван Иванович", 31, 375295127601L),
                new Costumer("Петров Петр Петрович", 26, 375332318813L)
        };
        Product[] products = {
                new Product("Шуруповерт Bosh", "200$"),
                new Product("Строительный пылесос Kerher", "350$"),
                new Product("Электролобзик Makita", "280$"),
                new Product("Набор бит Bosh", "50$"),
                new Product("Перфоратор Wortex", "310$")
        };
        Order[] orders = new Order[orderSizeArray];
    }
}
