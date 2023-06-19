package N5_TEST_TASKS_IT;

public class _S4_X_Raised_On_Y_USE_Recursion {
    //Write a method that calculates X Y using only addition. Use recursion!
    //Input: The integer X and Y.
    //Output: X on power Y, using only addition (+) and recursion.
    //Constraints: 1 ≤ X, Y ≤ 70

    public static long calculatePower(int x, int y) {
        if (y == 0) {
            return 1;  // Any number raised to the power of 0 is 1
        } else if (y % 2 == 0) {
            long temp = calculatePower(x, y / 2);
            return temp * temp;
        } else {
            long temp = calculatePower(x, y / 2);
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        int x1 = 2, y1 = 3;
        int x2 = 4, y2 = 3;
        System.out.println(x1 + " raised to the power of " + y1 + ": " + calculatePower(x1, y1));
        System.out.println(x2 + " raised to the power of " + y2 + ": " + calculatePower(x2, y2));
    }
}
