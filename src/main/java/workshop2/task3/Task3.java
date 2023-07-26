package workshop2.task3;

import java.util.Arrays;
import java.util.Locale;

public class Task3 {
    public static void main(String[] args) {
        int[] original = {3, 5, 7, 9, 11, 32, 1, 15};
        System.out.println("исходный массив -> ".toUpperCase(Locale.ROOT) + Arrays.toString(original));
        System.out.println("      смещенный -> ".toUpperCase(Locale.ROOT) + Arrays.toString(shiftNumbers(original, 2)));
    }

    public static int[] shiftNumbers(int[] originalArray, int n) {
        n %= originalArray.length;
        int shift = originalArray.length + n;
        shift %= originalArray.length;
        for (int i = 0; i < shift; i++) {
            int temp = originalArray[originalArray.length - 1];
            System.arraycopy(originalArray, 0, originalArray, 1, originalArray.length - 1);
            originalArray[0] = temp;
        }
        return originalArray;
    }
}
