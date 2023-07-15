package N5_TEST_TASKS_IT;

//Write a method that by given array of integers, and a positive number X, re-
//turns the product of all odd elements that are greater than X. Use recursion!

public class _S6_Product_Of_Odds_Recursion {
    public static int getProductOfOddsGreaterThanX(int[] array, int X) {
        return getProductHelper(array, X, 0, 1);
    }

    private static int getProductHelper(int[] array, int X, int index, int product) {
        if (index >= array.length) {
            return product;
        }

        if (array[index] % 2 != 0 && array[index] > X) {
            product *= array[index];
        }

        return getProductHelper(array, X, index + 1, product);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6};
        int X = 3;

        int product = getProductOfOddsGreaterThanX(array, X);
        System.out.println("Product of odd elements greater than " + X + ": " + product);
    }
}
