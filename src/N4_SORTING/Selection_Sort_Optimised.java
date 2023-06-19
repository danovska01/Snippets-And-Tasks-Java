package N4_SORTING;

import java.util.Arrays;

public class Selection_Sort_Optimised {
    // !! докато преглеждаме всички
    //елементи да намираме едновременно най-големия и най-малкия.
    static void selectionSort(int[] num) {
// за удобство ще си пазим докъде сме подредили
// в краищата на масива
        int start = 0;
        int end = num.length - 1;
// броим до <броя елементи делено на две>
// тъй като на всяка стъпка 2 елемента отиват на мястото си
        for (int sortedCount = 0; sortedCount <
                num.length / 2; sortedCount++) {

            int maxIndex = start;
            int minIndex = start;
// намираме индексите на най-голямия и най-малкия елемент
            for (int index = start; index <= end; index++) {
                if (num[index] > num[maxIndex]) {
                    maxIndex = index;
                }
                if (num[index] < num[minIndex]) {
                    minIndex = index;
                }
            }
            int temp = num[maxIndex];
            num[maxIndex] = num[end];
            num[end] = temp;

            if (minIndex == end) {
                minIndex = maxIndex;
            }

            temp = num[minIndex];
            num[minIndex] = num[start];
            num[start] = temp;

            end--;
            start++;
        }


    }
    public static void main(String[] args) {
// примерен масив с числа
        int[] num = { 6, 82, 12, 41, 40, 59, -32, -61 };
        selectionSort(num);
// извеждаме сортирания масив
        System.out.println(Arrays.toString(num));
    }


}