package N4_SORTING;

import java.util.Arrays;

public class Bubble_Sort_Optimised {
    // функция, която ще сортира подаден
// като параметър масив
    public static void bubbleSort(int[] num) {
// повтаряме толкова пъти, колкото са елементите
        for (int i=0; i<num.length; i++) {
// дали сме извършили размяна във вътрешния цикъл
            boolean hasASwap = false;
// от първия до предпоследния елемент минус броя завъртания на горния цикъл
            for (int j=0; j<num.length - 1 - i; j++) {
// сравняваме текущия елемент със следващия
// ако не са в правилната последователност, ги разменяме
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
// отбелязваме, че масива все още не е сортиран
                    hasASwap = true;
                }
            }
// ако нито една размяна не се е случила
// то масива вече е сортиран и прекратяваме външния цикъл
            if (!hasASwap) {
                break;
            }
        }
    }
    public static void main(String[] args) {
// примерен масив с числа
        int[] num = { 6, 82, 129, 211, 4, 259, -32, 161 };
        bubbleSort(num);
// извеждаме сортирания масив
        System.out.println(Arrays.toString(num));
    }
}
