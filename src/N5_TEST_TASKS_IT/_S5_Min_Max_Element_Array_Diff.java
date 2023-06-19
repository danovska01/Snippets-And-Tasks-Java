package N5_TEST_TASKS_IT;

public class _S5_Min_Max_Element_Array_Diff {

    //Write a method that finds and retrieves the difference between the minimum
    //and the maximum element in an array of numbers. Use recursion.
    public static int findDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        return findDifferenceRecursive(arr, 0, arr.length - 1);
    }

    private static int findDifferenceRecursive(int[] arr, int start, int end) {
        if (start == end) {
            return 0; // Base case: Only one element, so difference is zero
        } else if (start == end - 1) {
            return Math.abs(arr[start] - arr[end]); // Base case: Two elements, return the difference
        } else {
            int mid = (start + end) / 2;
            int diff1 = findDifferenceRecursive(arr, start, mid);
            int diff2 = findDifferenceRecursive(arr, mid + 1, end);

            return Math.max(diff1, diff2);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 2, 10, 5, 1 };
        int difference = findDifference(arr);
        System.out.println("Difference between minimum and maximum elements: " + difference);
    }
}
