package N4_SORTING;

import java.util.Arrays;

public class Binary_Search {
    public static void main(String[] args) {
//инициализираме масива
        int[] array = new int[15];
//запълваме с числа от 1 до 15
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int x = 9;
        System.out.println(Arrays.toString(array));
//извикваме binarySearch метода, като index връща индекса на търсения елемент
        int index = binarySearch(array, x, 0, array.length - 1); //start = 0, end = дължината на масива - 1
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int x, int start, int end) {
//нашето предположение е mid елемента
        int mid = (end + start) / 2;
        if (start > end) {//ако не съществува елемент в масива със стойност х
            return -1;
        }
        if (x == arr[mid]) { // ако сме познали числото
            return mid;
        } else if (x < arr[mid]) { //ако числото е по-малко от елемента в средата, съкращаваме диапазона
            return binarySearch(arr, x, start, mid - 1);
        } else if (x > arr[mid]) { //ако числото е по-голямо от елемента в средата, съкращаваме диапазона
            return binarySearch(arr, x, mid + 1, end);
        }
        return -1;
    }
}
