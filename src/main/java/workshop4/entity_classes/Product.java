package workshop4.entity_classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String title;
    private String price;
}
