package workshop4.entity_classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Costumer bayer;
    private Product product;
    private int amount;


}
