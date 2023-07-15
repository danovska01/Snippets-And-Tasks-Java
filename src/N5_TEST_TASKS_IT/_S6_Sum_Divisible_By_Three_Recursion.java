package N5_TEST_TASKS_IT;

//Write a method that by given array of integers returns the sum of all elements
//that are divisible by 3.

// Use recursion!

public class _S6_Sum_Divisible_By_Three_Recursion {
    public static int sumDivisibleByThree(int[] array, int index) {
        if (index < 0) {
            return 0;
        }

        int currentElement = array[index];
        int sum = sumDivisibleByThree(array, index - 1);

        if (currentElement % 3 == 0) {
            sum += currentElement;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 12, 6, 15, 8, 18};
        int sum = sumDivisibleByThree(array, array.length - 1);
        System.out.println("Sum of elements divisible by 3: " + sum);
    }
}
