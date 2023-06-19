package N5_TEST_TASKS_IT;

public class _S5_NegativeCounter {

    // Write a method that takes a sorted array of numbers and retrieves the number
    //of negative elements in the array. Try to achieve this with the lowest possible complexity.
    public static int countNegativeElements(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                // Found a negative element
                count += mid - left + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -1, 0, 2, 5, 7};
        int count = countNegativeElements(nums);
        System.out.println("Number of negative elements: " + count);
    }
}
