package workshop2.task2;

public class Task2 {
    public static void main(String[] args) {
        String original = "123456789";
        int key = 1;
        boolean code = false;
        System.out.println(caesarCode(original, key, code));
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
