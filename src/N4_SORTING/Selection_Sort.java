package N4_SORTING;

import java.util.Arrays;

public class Selection_Sort {
    static void selectionSort(int[] num) {
// ще подредим всички елементи без един тъй като той ще си бъде на мястото, след като подредим останалите
        for (int sortedCount = 1; sortedCount < num.length;
             sortedCount++) {
            int maxIndex = 0;
// намираме индекса на най-голямия елемент, като първо допускаме, че е с индекс 0 и обновяваме, ако намерим по-голям
            for (int index = 0; index <= num.length - sortedCount; index++) {
                if (num[index] > num[maxIndex]) {
                    maxIndex = index;
                }
            }
// разменяме като го слагаме на последна позиция минус броя на вече наредените елементи
            int temp = num[maxIndex];
            num[maxIndex] = num[num.length - sortedCount];
            num[num.length - sortedCount] = temp;
        }
    }

    public static void main(String[] args) {
// примерен масив с числа
        int[] num = {400, 6, 812, 120, 410, 41, 59, -2, 61};
        selectionSort(num);
// извеждаме сортирания масив
        System.out.println(Arrays.toString(num));
    }
}
