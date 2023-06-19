package N4_SORTING;

import java.util.Arrays;

public class Counting_Sort {
    public static int[] countingSort(int[] nums) {
        int[] numbersCount = new int[10]; // assuming the numbers range from 0 to 9
        int[] result = new int[nums.length];

        for (int num : nums) {
            numbersCount[num]++;
        }

        for (int index = 1; index < numbersCount.length; index++) {
            numbersCount[index] += numbersCount[index - 1];
        }

        for (int index = nums.length - 1; index >= 0; index--) {
            int num = nums[index];
            numbersCount[num]--;
            int pos = numbersCount[num];
            result[pos] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = countingSort(new int[]{1, 1, 1, 1, 1, 3, 2, 3, 2, 1});
        System.out.println(Arrays.toString(result));
    }
}
