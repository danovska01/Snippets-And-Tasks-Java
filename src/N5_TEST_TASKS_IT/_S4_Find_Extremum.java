package N5_TEST_TASKS_IT;

public class _S4_Find_Extremum {

    // Напишете метод int findExtremum(int[] arr), която намира екстремума на масива
    //arr, който е или хълм или падина.
    //Направете го с възможно най-малка сложност на алгоритъма по време.
    //Input: Масив с големина N, който е хълм или падина. N трябва да е цяло положи-
    //телно число <=70 000 000
    //Output: Индекса на елемента - екстремум на масива.

    public static int findExtremum(int[] arr) {
        int length = arr.length;
        int start = 0;
        int end = length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 30, 50, 40, 20};
        int[] arr2 = {10, 20, 30};
        int[] arr3 = {10, 7, 70};
        int[] arr4 = {14, 13, 12, 11};

        System.out.println("Extremum index: " + findExtremum(arr1));  // Output: 3 (хълм)
        System.out.println("Extremum index: " + findExtremum(arr2));  // Output: 2 (хълм)
        System.out.println("Extremum index: " + findExtremum(arr3));  // Output: 1 (падина)
        System.out.println("Extremum index: " + findExtremum(arr4));  // Output: 3 (падина)
    }

}
