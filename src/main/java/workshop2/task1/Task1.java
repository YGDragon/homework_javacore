package workshop2.task1;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        //Составление исходного массива случайных чисел
        int minRand = -20;
        int maxRand = 20;
        int sizeArray = getArraySize(minRand, maxRand);
        int[] originalArray = getRandomArray(sizeArray, minRand, maxRand);
        System.out.println(Arrays.toString(originalArray));
        int[] sortedArray = countingSort(originalArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] getRandomArray(int sizeArray, int min, int max) {
        Random rand = new Random();
        int[] randArray = new int[sizeArray];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = rand.nextInt(min, max);
        }
        return randArray;
    }

    public static int getArraySize(int min, int max) {
        int negative = -1;
        if (max <= min) {
            System.out.println("Недопустимые значения min и max");
            return 0;
        } else if (min < 0) {
            min = min * negative + 1;
        }
        return min + max;
    }

    public static int[] countingSort(int[] originalArray) {
        //Найдем минимальное и максимальное число в исходном массиве
        int min = originalArray[0];
        int max = originalArray[1];
        for (int i = 2; i < originalArray.length; i++) {
            if (originalArray[i] < min) {
                min = originalArray[i];
            } else if (originalArray[i] > max) {
                max = originalArray[i];
            }
        }
        //Запишем опорный массив элементов от минимального значения до максимального
        int[] bearingArray = new int[getArraySize(min, max)];
        for (int i = 0; i < bearingArray.length; i++) {
            bearingArray[i] = min + i;
        }
        //Запишем в промежуточный массив количество вхождений каждого элемента поиндексно в исходном массиве
        int[] tempArray = new int[bearingArray.length];//промежуточный массив
        for (int i = 0; i < bearingArray.length; i++) {
            int count = 0;//счетчик вхождений элементов исходного массива
            for (int value : originalArray
            ) {
                if (value == bearingArray[i]) {
                    count++;
                }
            }
            tempArray[i] = count;
        }
        //Вставим элементы в исходный массив
        int j = 0;
        for (int i = 0; i < tempArray.length; i++) {
            int count = 0;
            while (count < tempArray[i]) {
                originalArray[j] = bearingArray[i];
                count++;
                j++;
            }
        }
        return originalArray;
    }
}
