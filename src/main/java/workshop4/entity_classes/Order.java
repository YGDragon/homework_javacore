package workshop4.entity_classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Costumer costumer;
    private Product product;
    private int amount;

    @Override
    public String toString() {
        return String.format(
                "%s/%dлет/+%s/%s/%s$/%sшт",
                costumer.getName(), costumer.getAge(), costumer.getPhone(),
                product.getTitle(), product.getPrice(),
                amount);
    }
}
