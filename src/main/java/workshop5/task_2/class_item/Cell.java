package workshop5.task_2.class_item;

import lombok.Data;

@Data
public class Cell {
    public static String[] state = {"•", "X", "0", "R"};
    private int currentState;

    public Cell() {
        this.currentState = 0;
    }

    @Override
    public String toString() {
        switch (currentState) {
            case 0 -> {
                return state[0];
            }
            case 1 -> {
                return state[1];
            }
            case 2 -> {
                return state[2];
            }
            case 3 -> {
                return state[3];
            }
        }
        return null;
    }
}
