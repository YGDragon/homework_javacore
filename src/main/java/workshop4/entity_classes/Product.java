package workshop4.entity_classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String title;
    private int price;

    @Override
    public String toString() {
        return String.format("%s: %s$", title, price);
    }
}
