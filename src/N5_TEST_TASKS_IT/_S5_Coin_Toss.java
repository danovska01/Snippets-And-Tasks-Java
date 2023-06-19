package N5_TEST_TASKS_IT;

import java.util.Scanner;

public class _S5_Coin_Toss {

    // Write a program that reads the result of a coin toss from the console. The
    //possible inputs are “Heads” or “Tails”. The inputs are infinite. The program must stop
    //reading only if there are 5 consecutive “Heads” coin tosses.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int consecutiveHeads = 0;

        while (true) {
            System.out.print("Enter the result of the coin toss (Heads/Tails): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Heads")) {
                consecutiveHeads++;

                if (consecutiveHeads == 5) {
                    System.out.println("5 consecutive Heads! Exiting the program.");
                    break;
                }
            } else {
                consecutiveHeads = 0;
            }
        }

        scanner.close();
    }
}
