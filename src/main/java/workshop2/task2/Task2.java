package workshop2.task2;

import java.util.Locale;

public class Task2 {
    public static void main(String[] args) {
        String original = "123456789";
        int key = 2;
        boolean code = true;
        System.out.println("исходная строка -> ".toUpperCase(Locale.ROOT) + original);
        System.out.println("  зашифрованная -> " + caesarCode(original, key, code));
    }

    private static String caesarCode(String original, int key, boolean code) {
        if (original == null || original.isEmpty())
            return null;
        char[] encoded = new char[original.length()];
        for (int i = 0; i < original.length(); ++i) {
            encoded[i] = (char) (original.charAt(i) + ((code) ? key : -key));
        }
        return new String(encoded);
    }
}
