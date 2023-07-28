package workshop4.entity_classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Costumer {
    private String name;
    private int age;
    private String phone;

}
