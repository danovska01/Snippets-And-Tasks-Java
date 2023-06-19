package N4_SORTING;

import java.util.Arrays;

public class Quick_Sort {
    // разменя два елемента в масив
    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
// взема най-десния елемент в някакъв интервал и го поставя на мястото му, като елементите в ляво от него ще са по-малки или равни, а в дясно - по-големи
// като резултат връща мястото на елемента в масива
    static int partition(int a[], int left, int right) {
// той ще е нашия "разделител"
        int pivot = a[right];
//К показва края на интервала с по-малките лементи в началото допускаме, че няма по-малки елементи от нашия разделител
        int k = left-1;
// обхождаме целия интервал
        for (int index=left; index<=right; index++) {
// ако намерим по-малък от нашия разделител
            if (a[index] <= pivot) {
k++;
// и поставяме текущия при по-малките като го разменяме с някой по-голям
swap(a, k, index);
}
}

return k;
}
// рекурсивен метод, който сортира масива в граници от ляво до дясно
static void quickSort(int a[], int left, int right) {
// дъното на нашата рекурсия - да имаме 1 или по- малко елементи или с други думи - границите да съвпаднат
if (left >= right) {
return;
}
// разделяме масива и запазваме позицията "K" на разделителя
int k = partition(a, left, right);
    quickSort(a, left, k-1);
    quickSort(a, k+1, right);
}
    public static void main(String[] args) {
        int a[] = new int[]{3213, 1322, 123, 221, 9731,
                233,234,241, 254, 261,239, 92,23, 9, 85181};
// извикваме метода с масива и в граници от първия до последния елемент
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
