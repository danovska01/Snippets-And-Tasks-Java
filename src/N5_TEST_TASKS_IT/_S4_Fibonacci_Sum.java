package N5_TEST_TASKS_IT;

public class _S4_Fibonacci_Sum {
    //Print all Fibonacci numbers less than N (first and second Fibonacci
    //numbers are 0 and 1) and their total sum.
    //Input: A positive integer number N not greater than 700 000
    //Output: Fibonacci sequence with elements less than N and their sum

    public static void printFibonacciNumbers(int N) {
        int first = 0;
        int second = 1;
        int sum = 0;

        System.out.println("Fibonacci sequence with elements less than " + N + ":");
        System.out.print(first + " ");

        while (second < N) {
            System.out.print(second + " ");
            sum += second;

            int temp = second;
            second = first + second;
            first = temp;
        }

        System.out.println("\nTotal sum of Fibonacci numbers: " + sum);
    }

    public static void main(String[] args) {
        int N = 100;
        printFibonacciNumbers(N);
    }
}
