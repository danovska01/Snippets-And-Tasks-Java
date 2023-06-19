package N5_TEST_TASKS_IT;

import java.util.Random;

public class _S5_Dice_Roll {
    public static void main(String[] args) {

        //Write a program that asks you to roll two dice and checks the sum of their
        //values. The program asks you to throw the dice until you achieve seven consecutive
        //sums of value '7'. After that the program must tell you how many total tries you have
        //done to achieve this result.

        int consecutiveSevens = 0;
        int totalTries = 0;

        while (consecutiveSevens < 7) {
            int dice1 = rollDice();
            int dice2 = rollDice();
            int sum = dice1 + dice2;

            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            System.out.println("Sum: " + sum);
            System.out.println("---------------------");

            if (sum == 7) {
                consecutiveSevens++;
            } else {
                consecutiveSevens = 0;
            }

            totalTries++;
        }

        System.out.println("Congratulations! You achieved seven consecutive sums of value 7.");
        System.out.println("Total tries: " + totalTries);
    }

    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generate a random number between 1 and 6
    }
}
