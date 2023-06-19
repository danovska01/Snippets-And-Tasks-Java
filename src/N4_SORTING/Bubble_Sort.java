package N4_SORTING;

import java.util.Arrays;

public class Bubble_Sort {
    // метод, който ще сортира подаден като параметър масив
    public static void bubbleSort(int[] num) {
// повтаряме толкова пъти, колкото са елементите
        for (int i=0; i<num.length; i++) {
// от първия до предпоследния елемент
            for (int j=0; j<num.length-1; j++) {
// сравняваме текущия елемент със следващия
// ако не са в правилната последователност, ги разменяме
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {

// примерен масив с числа
        int[] num = { 6, 82, 12, 1, 4, 59, -32, 61 };
        bubbleSort(num);
// извеждаме сортирания масив
        System.out.println(Arrays.toString(num));
    }
}
