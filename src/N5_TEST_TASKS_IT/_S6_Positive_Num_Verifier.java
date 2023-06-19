package N5_TEST_TASKS_IT;

public class _S6_Positive_Num_Verifier {

    // Write a method that by given array of integers verifies whether all the elements are positive numbers.
    // The method must return result of type boolean. Use recursion!
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, -2, 3, 4, 5};

        System.out.println(verifyAllPositive(arr1)); // Output: true
        System.out.println(verifyAllPositive(arr2)); // Output: false
    }

    public static boolean verifyAllPositive(int[] arr) {
        return verifyAllPositiveRecursive(arr, 0);
    }

    private static boolean verifyAllPositiveRecursive(int[] arr, int index) {
        if (index == arr.length) {
            return true; // All elements have been checked and are positive
        }

        if (arr[index] <= 0) {
            return false; // Found a non-positive element
        }

        return verifyAllPositiveRecursive(arr, index + 1);
    }
}
